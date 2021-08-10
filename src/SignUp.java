import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class SignUp extends JFrame implements ActionListener {
    JPanel contentPane;
    JTextField tf, tf1, tf2, tf3;
    JButton b1, b2;
    JComboBox comboBox;
    JLabel mylabel;
    ImageIcon background;

    public SignUp() {
        setBounds(600, 250, 606, 406);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        //contentPane.setBackground(new Color(0,255,0));
        contentPane.setLayout(null);

        background = new ImageIcon(this.getClass().getResource("Photos/Background.jpg"));
        mylabel = new JLabel(background);
        mylabel.setSize(600, 400);
        contentPane.add(mylabel);

        JLabel lblUsername = new JLabel("Username :");
        lblUsername.setForeground(new Color(0,0,153));
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblUsername.setBounds(99, 86, 92, 26);
        mylabel.add(lblUsername);

        JLabel lblName = new JLabel("Name :");
        lblName.setForeground(new Color(0,0,153));
        lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblName.setBounds(99, 123, 92, 26);
        mylabel.add(lblName);

        JLabel lblPassword = new JLabel("Password :");
        lblPassword.setForeground(new Color(0,0,153));
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPassword.setBounds(99, 160, 92, 26);
        mylabel.add(lblPassword);

        JLabel lblAnswer = new JLabel("Answer :");
        lblAnswer.setForeground(new Color(0,0,153));
        lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblAnswer.setBounds(99, 234, 92, 26);
        mylabel.add(lblAnswer);

        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] { "Your NickName?", "Your Lucky Number?",
                "Your child SuperHero?", "Your childhood Name ?" }));
        comboBox.setBounds(265, 202, 148, 20);
        mylabel.add(comboBox);

        JLabel lblSecurityQuestion = new JLabel("Security Question :");
        lblSecurityQuestion.setForeground(new Color(0,0,153));
        lblSecurityQuestion.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblSecurityQuestion.setBounds(99, 197, 140, 26);
        mylabel.add(lblSecurityQuestion);

        tf = new JTextField();
        tf.setBounds(265, 91, 148, 20);
        mylabel.add(tf);
        tf.setColumns(10);

        tf1 = new JTextField();
        tf1.setColumns(10);
        tf1.setBounds(265, 128, 148, 20);
        mylabel.add(tf1);

        tf2 = new JTextField();
        tf2.setColumns(10);
        tf2.setBounds(265, 165, 148, 20);
        mylabel.add(tf2);

        tf3 = new JTextField();
        tf3.setColumns(10);
        tf3.setBounds(265, 239, 148, 20);
        mylabel.add(tf3);

        b1 = new JButton("Create");
        b1.addActionListener(this);
        b1.setFont(new Font("Tahoma", Font.BOLD, 13));
        b1.setBounds(140, 289, 100, 30);
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        mylabel.add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setFont(new Font("Tahoma", Font.BOLD, 13));
        b2.setBounds(300, 289, 100, 30);
        b2.setBackground(Color.BLUE);
        b2.setForeground(Color.WHITE);
        mylabel.add(b2);

        JPanel panel = new JPanel();
        panel.setForeground(new Color(34, 139, 34));
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 51), 2), "Create-Account",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 102)));
        panel.setBounds(31, 46, 476, 296);
        //panel.setBackground(Color.WHITE);
        panel.setOpaque(false);
        mylabel.add(panel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new SignUp();
    }
    public void actionPerformed(ActionEvent ae){
        try{
            connect con = new connect();

            if(ae.getSource() == b1){
                String sql = "insert into account(username, name, password, sec_q, sec_ans) values(?, ?, ?, ?, ?)";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, tf.getText());
                st.setString(2, tf1.getText());
                st.setString(3, tf2.getText());
                st.setString(4, (String) comboBox.getSelectedItem());
                st.setString(5, tf3.getText());

                int i = st.executeUpdate();
                if (i > 0){
                    JOptionPane.showMessageDialog(null, "successfully Created");
                }

                tf.setText("");
                tf1.setText("");
                tf2.setText("");
                tf3.setText("");
            }
            if(ae.getSource() == b2){
                this.setVisible(false);
                new Login().setVisible(true);

            }
        }catch(Exception e){

        }
    }
}


