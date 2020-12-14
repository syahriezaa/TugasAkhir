package database;

import java.sql.*;
import javax.swing.*;


public class connection {
    static Connection mysqlconfig;
    static Statement mysqlstm;
    public Connection configDB() {
        try {
            String url = "jdbc:mysql://localhost:3306/tugasakhir";
            String user = "root";
            String pass = "";
            Class.forName("com.mysql.jdbc.Driver");
           // mysqlconfig = DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            mysqlconfig = DriverManager.getConnection(url, user, pass);
            mysqlstm = mysqlconfig.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi GAGAL!\n"+e);
        }
        return mysqlconfig;
    }
}
