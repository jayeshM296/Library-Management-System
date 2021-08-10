import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;

public class ReturnBook extends JFrame implements ActionListener{

    JPanel contentPane;
    JTextField tf;
    JTextField tf_1;
    JTextField tf_2;
    JTextField tf_3;
    JTextField tf_4;
    JTextField tf_5;
    JTextField tf_6;
    JButton b1,b2,b3;
    JDateChooser dateChooser;
    JLabel mylabel;
    ImageIcon background;

    public static void main(String[] args) {
        new ReturnBook().setVisible(true);
    }

    public void delete() {
        try {
            connect con = new connect();
            String sql = "delete from issueBook where book_id=?";
            PreparedStatement st = con.c.prepareStatement(sql);
            st.setString(1, tf.getText());
            int i = st.executeUpdate();
            if (i > 0)
                JOptionPane.showConfirmDialog(null, "Book Returned");
            else
                JOptionPane.showMessageDialog(null, "error in Deleting");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }


    public ReturnBook() {
        setBounds(450, 300, 617, 363);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);

        background = new ImageIcon(this.getClass().getResource("Photos/Background2.jpg"));
        mylabel = new JLabel(background);
        mylabel.setSize(617, 363);
        contentPane.add(mylabel);

        JLabel lblNewLabel = new JLabel("Book_id");
        lblNewLabel.setForeground(new Color(0,0,153));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel.setBounds(52, 52, 87, 24);
        mylabel.add(lblNewLabel);

        JLabel lblStudentid = new JLabel("Student_id");
        lblStudentid.setForeground(new Color(0,0,153));
        lblStudentid.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblStudentid.setBounds(243, 52, 87, 24);
        mylabel.add(lblStudentid);

        JLabel lblBook = new JLabel("Book");
        lblBook.setForeground(new Color(0,0,153));
        lblBook.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblBook.setBounds(52, 98, 71, 24);
        mylabel.add(lblBook);

        JLabel lblName = new JLabel("Name");
        lblName.setForeground(new Color(0,0,153));
        lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblName.setBounds(300, 98, 71, 24);
        mylabel.add(lblName);

        JLabel lblCourse = new JLabel("Course");
        lblCourse.setForeground(new Color(0,0,153));
        lblCourse.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblCourse.setBounds(52, 143, 87, 24);
        mylabel.add(lblCourse);

        JLabel lblBranch = new JLabel("Branch");
        lblBranch.setForeground(new Color(0,0,153));
        lblBranch.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblBranch.setBounds(303, 144, 68, 24);
        mylabel.add(lblBranch);

        JLabel lblDateOfIssue = new JLabel("Date of Issue");
        lblDateOfIssue.setForeground(new Color(0,0,153));
        lblDateOfIssue.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblDateOfIssue.setBounds(52, 188, 105, 29);
        mylabel.add(lblDateOfIssue);

        JLabel lblDateOfReturn = new JLabel("Date of Return");
        lblDateOfReturn.setForeground(new Color(0,0,153));
        lblDateOfReturn.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblDateOfReturn.setBounds(52, 234, 118, 29);
        mylabel.add(lblDateOfReturn);

        tf = new JTextField();
        tf.setForeground(new Color(0,0,153));
        tf.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        tf.setBounds(128, 56, 105, 20);
        mylabel.add(tf);
        tf.setColumns(10);

        tf_1 = new JTextField();
        tf_1.setForeground(new Color(0,0,153));
        tf_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        tf_1.setBounds(340, 56, 93, 20);
        mylabel.add(tf_1);
        tf_1.setColumns(10);

        b1 = new JButton("Search");
        b1.addActionListener(this);
        b1.setBounds(443, 52, 105, 29);
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        mylabel.add(b1);

        tf_2 = new JTextField();
        tf_2.setEditable(false);
        tf_2.setForeground(new Color(0,0,153));
        tf_2.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
        tf_2.setBounds(128, 102, 162, 20);
        mylabel.add(tf_2);
        tf_2.setColumns(10);

        tf_3 = new JTextField();
        tf_3.setEditable(false);
        tf_3.setForeground(new Color(0,0,153));
        tf_3.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
        tf_3.setColumns(10);
        tf_3.setBounds(369, 102, 179, 20);
        mylabel.add(tf_3);

        tf_4 = new JTextField();
        tf_4.setEditable(false);
        tf_4.setForeground(new Color(0,0,153));
        tf_4.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
        tf_4.setColumns(10);
        tf_4.setBounds(128, 147, 162, 20);
        mylabel.add(tf_4);

        tf_5 = new JTextField();
        tf_5.setForeground(new Color(0,0,153));
        tf_5.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
        tf_5.setEditable(false);
        tf_5.setColumns(10);
        tf_5.setBounds(369, 147, 179, 20);
        mylabel.add(tf_5);

        tf_6 = new JTextField();
        tf_6.setForeground(new Color(0,0,153));
        tf_6.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
        tf_6.setEditable(false);
        tf_6.setColumns(10);
        tf_6.setBounds(167, 194, 162, 20);
        mylabel.add(tf_6);

        dateChooser = new JDateChooser();
        dateChooser.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
        dateChooser.setBounds(167, 234, 172, 29);
        dateChooser.setDateFormatString("YYYY-MM-dd\n\n");
        mylabel.add(dateChooser);

        b2 = new JButton("Return");
        b2.addActionListener(this);
        b2.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        b2.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
        b2.setBounds(369, 179, 149, 30);
        b2.setBackground(Color.BLUE);
        b2.setForeground(Color.WHITE);

        mylabel.add(b2);

        b3 = new JButton("Back");
        b3.addActionListener(this);
        b3.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        b3.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
        b3.setBounds(369, 231, 149, 30);
        b3.setBackground(Color.BLUE);
        b3.setForeground(Color.WHITE);
        mylabel.add(b3);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 51), 2, true), "Return-Panel",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 102)));
        panel.setBounds(10, 24, 569, 269);
        panel.setBackground(Color.WHITE);
        mylabel.add(panel);
        panel.setOpaque(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae){
        try{
            connect con = new connect();
            if(ae.getSource() == b1){
                String sql = "select * from issueBook where student_id = ? and book_id =?";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1, tf_1.getText());
                st.setString(2, tf.getText());
                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    tf_2.setText(rs.getString("bname"));
                    tf_3.setText(rs.getString("sname"));
                    tf_4.setText(rs.getString("course"));
                    tf_5.setText(rs.getString("branch"));
                    tf_6.setText(rs.getString("dateOfIssue"));
                }
                st.close();
                rs.close();

            }
            if(ae.getSource() == b2){
                String sql = "insert into returnBook(book_id, student_id, bname, sname,course, branch, dateOfIssue, dateOfReturn) values(?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1, tf.getText());
                st.setString(2, tf_1.getText());
                st.setString(3, tf_2.getText());
                st.setString(4, tf_3.getText());
                st.setString(5, tf_4.getText());
                st.setString(6, tf_5.getText());
                st.setString(7, tf_6.getText());

                st.setString(8, ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText());
                int i = st.executeUpdate();
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "Processing..");
                    delete();
                } else
                    JOptionPane.showMessageDialog(null, "error");

            }
            if(ae.getSource() == b3){
                this.setVisible(false);
                new Home().setVisible(true);

            }
        }catch(Exception e){

        }
    }
}