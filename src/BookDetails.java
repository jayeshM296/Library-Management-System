import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.awt.event.*;

public class BookDetails extends JFrame implements ActionListener{
    JPanel panel;
    JTable table;
    JTextField search;
    JButton b1,b2;
    JLabel mylabel;
    ImageIcon background;

    public static void main(String[] args) {
        new BookDetails().setVisible(true);
    }

    public void Book() {
        try {
            connect con = new connect();
            String sql = "select * from book";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            table.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            st.close();
            con.c.close();
        } catch (Exception e) {

        }
    }

    public BookDetails() {
        setBounds(350, 200, 890, 475);
        panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panel);
        panel.setLayout(null);

        background = new ImageIcon(this.getClass().getResource("Photos/Background2.jpg"));
        mylabel = new JLabel(background);
        mylabel.setSize(900, 500);
        panel.add(mylabel);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(79, 133, 771, 282);
        mylabel.add(scrollPane);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                int row = table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row, 1).toString());
            }
        });
        table.setBackground(new Color(0, 248, 255));
        table.setForeground(Color.BLUE);
        table.setFont(new Font("Times New Roman", Font.BOLD, 16));
        scrollPane.setViewportView(table);

        JButton b1 = new JButton("Search");
        b1.addActionListener(this);
        b1.setBorder(new LineBorder(new Color(0, 0, 51), 2, true));
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        b1.setIcon(i3);
        b1.setForeground(new Color(0,0,153));
        b1.setFont(new Font("Times New Roman", Font.BOLD, 18));
        b1.setBounds(564, 89, 138, 33);
        mylabel.add(b1);

        JButton b2 = new JButton("Delete");
        b2.addActionListener(this);
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/nineth.png"));
        Image i5 = i4.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        b2.setIcon(i6);
        b2.setForeground(new Color(0,0,153));
        b2.setFont(new Font("Times New Roman", Font.BOLD, 18));
        b2.setBorder(new LineBorder(new Color(0, 0, 51), 2, true));
        b2.setBounds(712, 89, 138, 33);
        mylabel.add(b2);


        JLabel l1 = new JLabel("Book Details");
        l1.setForeground(new Color(0,0,153));
        l1.setFont(new Font("Times New Roman", Font.BOLD, 30));
        l1.setBounds(300, 15, 400, 47);
        mylabel.add(l1);


        search = new JTextField();
        search.setBackground(new Color(255, 240, 245));
        search.setBorder(new LineBorder(new Color(0, 0, 51), 2, true));
        search.setForeground(new Color(0,0,153));
        search.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        search.setBounds(189, 89, 357, 33);
        mylabel.add(search);
        search.setColumns(10);

        JLabel l3 = new JLabel("Back");
        l3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                Home home = new Home();
                home.setVisible(true);
            }
        });
        l3.setForeground(Color.GRAY);
        l3.setFont(new Font("Times New Roman", Font.BOLD, 18));
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.png"));
        Image i8 = i7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        l3.setIcon(i9);
        l3.setBounds(97, 89, 72, 33);
        mylabel.add(l3);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 51), 3, true), "Book-Details",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 102)));
        panel.setBounds(67, 54, 793, 368);
        mylabel.add(panel);
        panel.setOpaque(false);
        Book();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae){
        try{

            connect con = new connect();
            if(ae.getSource() == b1){

                String sql = "select * from book where concat(name, book_id) like ?";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1, "%" + search.getText() + "%");
                ResultSet rs = st.executeQuery();

                table.setModel(DbUtils.resultSetToTableModel(rs));
                rs.close();
                st.close();

            }
            if(ae.getSource() == b2){
                String sql = "delete from book where name = '" + search.getText() + "'";
                PreparedStatement st = con.c.prepareStatement(sql);

                JDialog.setDefaultLookAndFeelDecorated(true);
                int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.NO_OPTION) {

                } else if (response == JOptionPane.YES_OPTION) {
                    int rs = st.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Deleted !!");
                } else if (response == JOptionPane.CLOSED_OPTION) {

                }
                st.close();


            }

            con.c.close();
        }catch(Exception e){

        }
    }
}