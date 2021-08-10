import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JPanel panel;
    JLabel lb1, lb2, lb3, mylabel, lb4;
    JTextField username;
    JPasswordField password;
    JButton login,signup,forgotpass;
    ImageIcon bookicon;

    public Login(){

        setBounds(600, 300, 600, 400);

        panel = new JPanel();
        setContentPane(panel);
        panel.setLayout(null);

        bookicon = new ImageIcon(this.getClass().getResource("Photos/Img1.jpg"));
        mylabel = new JLabel(bookicon);
        mylabel.setSize(600, 400);
        panel.add(mylabel);

        lb4 = new JLabel("Welcome");
        lb4.setForeground(new Color(255 ,255,0));
        lb4.setBounds(150, 50, 95, 24);
        lb4.setFont(new Font("Times New Roman", Font.PLAIN, 23));
        mylabel.add(lb4);

        lb1 = new JLabel("Username : ");
        lb1.setForeground(new Color(255 ,255,255));
        lb1.setBounds(64, 89, 95, 24);
        mylabel.add(lb1);

        lb2 = new JLabel("Password : ");
        lb2.setForeground(new Color(255 ,255,255));
        lb2.setBounds(64, 124, 95, 24);
        mylabel.add(lb2);

        username = new JTextField();
        username.setBounds(150, 93, 157, 20);
        mylabel.add(username);

        password = new JPasswordField();
        password.setBounds(150, 128, 157, 20);
        mylabel.add(password);

        login = new JButton("Login");
        login.addActionListener(this);
        login.setBounds(89, 181, 113, 39);
        mylabel.add(login);

        signup = new JButton("SignUp");
        signup.addActionListener(this);
        signup.setBounds(219, 181, 113, 39);
        mylabel.add(signup);

        forgotpass = new JButton("Forgot Password");
        forgotpass.addActionListener(this);
        forgotpass.setBounds(129, 231, 179, 39);
        mylabel.add(forgotpass);

        lb3 = new JLabel("Trouble in Login?");
        lb3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lb3.setForeground(new Color(255, 255, 255));
        lb3.setBounds(10, 240, 130, 20);
        mylabel.add(lb3);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
            Boolean status = false;
            try {
                connect con = new connect();
                String sql = "select * from account where username=? and password=?";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, username.getText());
                st.setString(2, password.getText());

                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    this.setVisible(false);
                    new Loading().setVisible(true);
                } else
                    JOptionPane.showMessageDialog(null, "Invalid Login...!.");

            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if(ae.getSource() == signup){
            setVisible(false);
            SignUp su = new SignUp();
            su.setVisible(true);
        }
        if(ae.getSource() == forgotpass){
            setVisible(false);
            Forgot forgot = new Forgot();
            forgot.setVisible(true);
        }
    }
    public static void main(String[] args) {

        new Login();
    }
}
