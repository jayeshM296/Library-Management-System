import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{

    JPanel panel;
    JButton b1,b2,b3,b4,b5,b6;
    JLabel mylabel;
    ImageIcon background;

    public Home() {

        setBounds(400, 150, 800, 800);
        panel = new JPanel();
        setContentPane(panel);
        panel.setLayout(null);

        background = new ImageIcon(this.getClass().getResource("Photos/Background3.jpg"));
        mylabel = new JLabel(background);
        mylabel.setSize(800, 800);
        panel.add(mylabel);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 128, 0), new Color(128, 128, 128)));
        menuBar.setBackground(Color.BLUE);
        menuBar.setBounds(0, 10, 1000, 35);
        mylabel.add(menuBar);

        JMenu mnExit = new JMenu("Exit");
        mnExit.setFont(new Font("Times New Roman", Font.BOLD, 17));
        mnExit.setForeground(new Color(255, 255 , 255));

        JMenuItem mntmLogout = new JMenuItem("Logout");
        mntmLogout.setBackground(new Color(211, 211, 211));
        mntmLogout.setForeground(new Color(105, 105, 105));
        mntmLogout.addActionListener(this);
        mnExit.add(mntmLogout);

        JMenuItem mntmExit = new JMenuItem("Exit");
        mntmExit.setForeground(new Color(105, 105, 105));
        mntmExit.setBackground(new Color(211, 211, 211));
        mntmExit.addActionListener(this);
        mnExit.add(mntmExit);
        
        JMenu mnHelp = new JMenu("Help");
        mnHelp.setFont(new Font("Times New Roman", Font.BOLD, 17));
        mnHelp.setForeground(new Color(255, 255 , 255));

       JMenuItem mntmAboutUs = new JMenuItem("About Us");
        mntmAboutUs.setForeground(new Color(105, 105, 105));
        mntmAboutUs.setBackground(new Color(211, 211, 211));
        mntmAboutUs.addActionListener(this);
        mnHelp.add(mntmAboutUs);

        JMenu mnRecord = new JMenu("Record");
        mnRecord.setFont(new Font("Times New Roman", Font.BOLD, 17));
        mnRecord.setForeground(new Color(255, 255 , 255));

        JMenuItem bookdetails = new JMenuItem("Book Details");
        bookdetails.addActionListener(this);
        bookdetails.setBackground(new Color(211, 211, 211));
        bookdetails.setForeground(Color.DARK_GRAY);
        mnRecord.add(bookdetails);

        JMenuItem studentdetails = new JMenuItem("Student Details");
        studentdetails.setBackground(new Color(211, 211, 211));
        studentdetails.setForeground(Color.DARK_GRAY);
        studentdetails.addActionListener(this);
        mnRecord.add(studentdetails);

        menuBar.add(mnRecord);
        menuBar.add(mnHelp);
        menuBar.add(mnExit);


        JLabel l1 = new JLabel("Library Management System");
        l1.setForeground(new Color(0,0,153));
        l1.setFont(new Font("Times New Roman", Font.BOLD, 30));
        l1.setBounds(200, 30, 701, 80);
        mylabel.add(l1);

        JLabel l2 = new JLabel("");
        l2.setVerticalAlignment(SwingConstants.TOP);
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/Add books.ico"));
        Image i2 = i1.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l2 = new JLabel(i3);
        l2.setBounds(60, 140, 159, 152);
        mylabel.add(l2);

        JLabel l3 = new JLabel("");
        ImageIcon i4  = new ImageIcon(ClassLoader.getSystemResource("icons/Statistics.png"));
        Image i5 = i4.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        l3 = new JLabel(i6);
        l3.setBounds(320, 160, 134, 128);
        mylabel.add(l3);

        JLabel l4 = new JLabel("");
        ImageIcon i7  = new ImageIcon(ClassLoader.getSystemResource("icons/Add student.png"));
        Image i8 = i7.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        l4 = new JLabel(i9);
        l4.setBounds(530, 140, 225, 152);
        mylabel.add(l4);

        b1 = new JButton("Add Books");
        b1.addActionListener(this);
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        b1.setBounds(60, 320, 159, 44);
        mylabel.add(b1);

        b2 = new JButton("Statistics");
        b2.addActionListener(this);
        b2.setBackground(Color.BLUE);
        b2.setForeground(Color.WHITE);
        b2.setBounds(313, 320, 139, 44);
        mylabel.add(b2);

        b3 = new JButton("Add Student");
        b3.addActionListener(this);
        b3.setBackground(Color.BLUE);
        b3.setForeground(Color.WHITE);
        b3.setBounds(562, 320, 167, 44);
        mylabel.add(b3);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 51), 2), "Operation", TitledBorder.LEADING,
                TitledBorder.TOP, null, new Color(0, 0, 102)));
        panel.setBounds(20, 120, 750, 260);
        mylabel.add(panel);
        panel.setOpaque(false);

        b4 = new JButton("Issue Book");
        b4.addActionListener(this);
        b4.setBackground(Color.BLUE);
        b4.setForeground(Color.WHITE);
        b4.setBounds(76, 620, 143, 41);
        mylabel.add(b4);

        b5 = new JButton("Return Book");
        b5.addActionListener(this);
        b5.setBackground(Color.BLUE);
        b5.setForeground(Color.WHITE);
        b5.setBounds(310, 620, 159, 41);
        mylabel.add(b5);

        b6 = new JButton("About Us");
        b6.addActionListener(this);
        b6.setBackground(Color.BLUE);
        b6.setForeground(Color.WHITE);
        b6.setBounds(562, 620, 159, 41);
        mylabel.add(b6);

        JLabel l5 = new JLabel("");
        ImageIcon i10  = new ImageIcon(ClassLoader.getSystemResource("icons/issue book.png"));
        Image i11 = i10.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        l5 = new JLabel(i12);
        l5.setBounds(60, 440, 159, 163);
        mylabel.add(l5);

        JLabel l6 = new JLabel("");
        ImageIcon i13  = new ImageIcon(ClassLoader.getSystemResource("icons/return book.png"));
        Image i14 = i13.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        l6 = new JLabel(i15);
        l6.setBounds(320, 440, 139, 152);
        mylabel.add(l6);

        JLabel l7 = new JLabel("");
        ImageIcon i16  = new ImageIcon(ClassLoader.getSystemResource("icons/About us.jpg"));
        Image i17 = i16.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
        ImageIcon i18 = new ImageIcon(i17);
        l7 = new JLabel(i18);
        l7.setBounds(562, 440, 157, 152);
        mylabel.add(l7);

        JPanel panel2 = new JPanel();
        panel2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 51), 2), "Action", TitledBorder.LEADING,
                TitledBorder.TOP, null, new Color(0, 0, 102)));
        panel2.setBounds(20, 420, 750, 270);
        panel2.setBackground(Color.WHITE);
        mylabel.add(panel2);
        panel2.setOpaque(false);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Home();
    }

    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        if(msg.equals("Logout")){
            setVisible(false);
            new Login().setVisible(true);
        }else if(msg.equals("Exit")){
            System.exit(ABORT);

        }else if(msg.equals("Read Me")){

        }else if(msg.equals("About Us")){
            setVisible(false);
            new AboutUs().setVisible(true);

        }else if(msg.equals("Book Details")){
            setVisible(false);
            new BookDetails().setVisible(true);
        }else if(msg.equals("Student Details")){
            setVisible(false);
            new StudentDetails().setVisible(true);

        }

        if(ae.getSource() == b1){
            this.setVisible(false);
            new AddBook().setVisible(true);
        }
        if(ae.getSource() == b2){
            this.setVisible(false);
            new Statistics().setVisible(true);
        }
        if(ae.getSource() == b3){
            this.setVisible(false);
            new AddStudent().setVisible(true);
        }
        if(ae.getSource() == b4){
            this.setVisible(false);
            new IssueBook().setVisible(true);
        }
        if(ae.getSource() == b5){
            this.setVisible(false);
            new ReturnBook().setVisible(true);

        }
        if(ae.getSource() == b6){
            this.setVisible(false);
            new AboutUs().setVisible(true);

        }

    }
}