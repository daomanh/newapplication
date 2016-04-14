/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class ConnectionUtil {
       public static Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            return DriverManager.getConnection("jdbc:sqlserver://TRUNGTHANH\\SQLEXPRESS:1433;databasename=CMR", "sa", "123456789");
            return DriverManager.getConnection("jdbc:sqlserver://TRUNGTHANH\\SQLEXPRESS:1433;databasename=CMR", "sa", "123456789");
//            return DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databasename=CMR", "sa", "123456789");
            //return DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=CMR", "sa", "gc00492");            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectionUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
