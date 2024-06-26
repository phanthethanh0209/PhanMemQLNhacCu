package ql_cuahang_nhaccu_class;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KetNoi {
    public Connection conn;
    
    public Connection KetNoiDuLieu() {
        try {
            String user = "sa";
            String pass = "123456";
            String url = "jdbc:sqlserver://localhost:1433;" +
                    "databaseName=QL_CUAHANG_NHACCU;trustServerCertificate=true";
            conn = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            Logger.getLogger(KetNoi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
}
