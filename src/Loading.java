import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class Loading extends JFrame implements Runnable {

    JPanel panel;
    JProgressBar progressBar;
    JLabel mylabel;
    Connection conn;
    int s;
    Thread th;
    ImageIcon bookicon;

    public Loading() {

        super("Loading");
        th = new Thread((Runnable) this);

        setBounds(600, 300, 600, 400);
        panel = new JPanel();
        setContentPane(panel);
        panel.setLayout(null);

        bookicon = new ImageIcon(this.getClass().getResource("Photos/Title.jpeg"));
        mylabel = new JLabel(bookicon);
        mylabel.setSize(600, 400);
        panel.add(mylabel);

        progressBar = new JProgressBar();
        progressBar.setFont(new Font("Times New Roman", Font.BOLD, 13));
        progressBar.setStringPainted(true);
        progressBar.setBounds(0, 345, 600, 25);
        mylabel.add(progressBar);

        JLabel lblNewLabel_2 = new JLabel("Please Wait....");
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setBounds(230, 300, 150, 20);
        mylabel.add(lblNewLabel_2);

        setUploading();
        setVisible(true);

    }

    public void setUploading() {
        setVisible(false);
        th.start();
    }

    public void run() {
        try {
            for (int i = 0; i < 200; i++) {
                s = s + 1;
                int m = progressBar.getMaximum();
                int v = progressBar.getValue();
                if (v < m) {
                    progressBar.setValue(progressBar.getValue() + 1);
                } else {
                    i = 201;
                    setVisible(false);
                    new Home().setVisible(true);
                }
                Thread.sleep(50);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

        new Loading();
    }
}