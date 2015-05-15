package server.mappers;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Paul on 02/05/2015.
 */
public class DatabaseAccess {
    static final String JDBC_DRIVE = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/clinic";
    static final String USER = "root";
    static final String PASS = "";
    static Connection connection = null;

    public DatabaseAccess() {
    }

    public void connectionSetup(){
        setConnection(getConnection());
    }

    public static final Connection getConnection() {
        System.out.println("ConnectionSetup");
        try {
            //register JDBC Driver
            Class.forName(JDBC_DRIVE);
            return DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        }
        return null;
    }

    public static void setConnection(Connection connection) {
        DatabaseAccess.connection = connection;
    }
}
