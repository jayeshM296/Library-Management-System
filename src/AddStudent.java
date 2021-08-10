import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AddStudent extends JFrame implements ActionListener {

    JPanel panel;
    JTextField t1, t2, t3;
    JComboBox comboBox, comboBox_1, comboBox_2, comboBox_3;
    JButton b1, b2;
    JLabel mylabel;
    ImageIcon background;

    public void random() {
        Random rd = new Random();
        t1.setText("" + rd.nextInt(10000 + 1));
    }

    public AddStudent() {
        super("Add Student");
        setBounds(700, 200, 550, 450);
        panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panel);
        panel.setLayout(null);

        background = new ImageIcon(this.getClass().getResource("Photos/Background.jpg"));
        mylabel = new JLabel(background);
        mylabel.setSize(600, 400);
        panel.add(mylabel);

        JLabel l1 = new JLabel("Student_id");
        l1.setForeground(new Color(0,0,153));
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setBounds(64, 63, 102, 22);
        mylabel.add(l1);

        JLabel l2 = new JLabel("Name");
        l2.setForeground(new Color(0,0,153));
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setBounds(64, 97, 102, 22);
        mylabel.add(l2);

        JLabel l3 = new JLabel("Father's Name");
        l3.setForeground(new Color(0,0,153));
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        l3.setBounds(64, 130, 102, 22);
        mylabel.add(l3);

        JLabel l4 = new JLabel("Branch");
        l4.setForeground(new Color(0,0,153));
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setBounds(64, 209, 102, 22);
        mylabel.add(l4);

        JLabel l5 = new JLabel("Year");
        l5.setForeground(new Color(0,0,153));
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        l5.setBounds(64, 242, 102, 22);
        mylabel.add(l5);

        JLabel l6 = new JLabel("Semester");
        l6.setForeground(new Color(0,0,153));
        l6.setFont(new Font("Tahoma", Font.BOLD, 14));
        l6.setBounds(64, 275, 102, 22);
        mylabel.add(l6);

        t1 = new JTextField();
        t1.setEditable(false);
        t1.setForeground(new Color(0,0,153));
        t1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t1.setBounds(174, 66, 156, 20);
        mylabel.add(t1);
        t1.setColumns(10);

        t2 = new JTextField();
        t2.setForeground(new Color(0,0,153));
        t2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t2.setColumns(10);
        t2.setBounds(174, 100, 156, 20);
        mylabel.add(t2);

        t3 = new JTextField();
        t3.setForeground(new Color(0,0,153));
        t3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t3.setColumns(10);
        t3.setBounds(174, 133, 156, 20);
        mylabel.add(t3);

        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"Mechanical", "CSE", "IT", "Civil", "Automobile", "EEE", "Other"}));
        comboBox.setForeground(new Color(0,0,153));
        comboBox.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        comboBox.setBounds(176, 211, 154, 20);
        mylabel.add(comboBox);

        comboBox_1 = new JComboBox();
        comboBox_1.setModel(new DefaultComboBoxModel(new String[]{"First", "Second", "Third", "Four"}));
        comboBox_1.setForeground(new Color(0,0,153));
        comboBox_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        comboBox_1.setBounds(176, 244, 154, 20);
        mylabel.add(comboBox_1);

        comboBox_2 = new JComboBox();
        comboBox_2.setModel(
                new DefaultComboBoxModel(new String[]{"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th"}));
        comboBox_2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        comboBox_2.setForeground(new Color(0,0,153));
        comboBox_2.setBounds(176, 277, 154, 20);
        mylabel.add(comboBox_2);

        b1 = new JButton("ADD");
        b1.addActionListener(this);
        b1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        b1.setBounds(64, 321, 111, 33);
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        mylabel.add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        b2.setBounds(198, 321, 111, 33);
        b2.setBackground(Color.BLUE);
        b2.setForeground(Color.WHITE);
        mylabel.add(b2);

        JLabel l7 = new JLabel("Course");
        l7.setForeground(new Color(0,0,153));
        l7.setFont(new Font("Tahoma", Font.BOLD, 14));
        l7.setBounds(64, 173, 102, 22);
        mylabel.add(l7);

        comboBox_3 = new JComboBox();
        comboBox_3.setModel(new DefaultComboBoxModel(
                new String[]{"B.E", "B.Tech", "M.Tech", "MBA", "BBA", "BCA", "B.Sc", "M.Sc", "B.Com", "M.Com"}));
        comboBox_3.setForeground(new Color(0,0,153));
        comboBox_3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        comboBox_3.setBounds(176, 176, 154, 20);
        mylabel.add(comboBox_3);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 51), 2, true), "Add-Student",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 102)));
        panel.setBackground(new Color(211, 211, 211));
        panel.setBounds(10, 38, 358, 348);
        panel.setOpaque(false);

        mylabel.add(panel);
        random();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        new AddStudent();
    }
    public void actionPerformed(ActionEvent ae){
        try{

            if(ae.getSource() == b1){
                try{
                    connect con = new connect();
                    String sql = "insert into student(student_id, name, father, course, branch, year, semester) values(?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement st = con.c.prepareStatement(sql);
                    st.setString(1, t1.getText());
                    st.setString(2, t2.getText());
                    st.setString(3, t3.getText());
                    st.setString(4, (String) comboBox_3.getSelectedItem());
                    st.setString(5, (String) comboBox.getSelectedItem());
                    st.setString(6, (String) comboBox_1.getSelectedItem());
                    st.setString(7, (String) comboBox_2.getSelectedItem());

                    int i = st.executeUpdate();
                    if (i > 0){
                        JOptionPane.showMessageDialog(null, "Successfully Added");
                        this.setVisible(false);
                        new Home().setVisible(true);
                    }
                    else
                        JOptionPane.showMessageDialog(null, "error");
                }catch(Exception e){
                    e.printStackTrace();
                }
            }

            if(ae.getSource() == b2){
                this.setVisible(false);
                new Home().setVisible(true);
            }
        }catch(Exception e){

        }
    }
}

