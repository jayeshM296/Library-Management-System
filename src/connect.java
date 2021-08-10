import java.sql.*;
public class connect {
    public Connection c;
    public Statement s;

    public connect() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?characterEncoding=latin1", "root", "g@rDen11Rj");
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}