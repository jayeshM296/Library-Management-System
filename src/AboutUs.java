import java.awt.*;
import javax.swing.*;

public class AboutUs extends JFrame{

    JPanel panel;
    JLabel l1, l2, l3, mylabel;
    ImageIcon background;

    public AboutUs() {

        setBounds(500, 250, 700, 400);

        panel = new JPanel();
        setContentPane(panel);
        panel.setLayout(null);

        background = new ImageIcon(this.getClass().getResource("Photos/Background2.jpg"));
        mylabel = new JLabel(background);
        mylabel.setSize(700, 400);
        panel.add(mylabel);

        l1 = new JLabel("Library Management System");
        l1.setForeground(new Color(0,0,153));
        l1.setFont(new Font("Times New Roman", Font.BOLD , 35));
        l1.setBounds(50, 40, 500, 55);
        mylabel.add(l1);

        l2 = new JLabel("Developed By : Jayesh Mahajan");
        l2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        l2.setForeground(new Color(0,0,255));
        l2.setBounds(50, 100, 600, 35);
        mylabel.add(l2);

        l3 = new JLabel("Github: https://github.com/jayeshM296 ");
        l3.setFont(new Font("Times New Roman", Font.BOLD, 20));
        l3.setForeground(new Color(0,0,255));
        l3.setBounds(50, 150, 600, 34);
        mylabel.add(l3);

        JLabel l4 = new JLabel("LinkedIn: https://www.linkedin.com/in/jayesh-mahajan-4888111b7 ");
        l4.setFont(new Font("Times New Roman", Font.BOLD, 20));
        l4.setForeground(new Color(0,0,255));
        l4.setBounds(50, 200, 600, 34);
        mylabel.add(l4);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new AboutUs();
    }

}
