import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class FirstPage extends JFrame implements ActionListener{

    JLabel l1;
    JButton b1;

    public FirstPage() {

        setSize(600,400);
        setLayout(null);
        setLocation(300,300);

        l1 = new JLabel("");
        b1 = new JButton("Next");

        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/Library.jpg"));
        Image i3 = i1.getImage().getScaledInstance(600, 400,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        l1 = new JLabel(i2);

        b1.setBounds(40,300,100,30);
        l1.setBounds(0, 0, 600, 400);

        l1.add(b1);
        add(l1);

        b1.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae){
        new Login().setVisible(true);
        this.setVisible(false);

    }

    public static void main(String[] args) {
        FirstPage window = new FirstPage();
        window.setVisible(true);
    }
}