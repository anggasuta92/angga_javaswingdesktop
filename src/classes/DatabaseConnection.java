/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import userinterface.FrmMain;
/**
 *
 * @author Angga Suta DHarmawan - 16101650
 */
public class DatabaseConnection {
    private static final String USER_DATABASE = "root";
    private static final String PASSWORD_DATABASE = "root";
    private static final String HOST_DATABASE = "localhost";
    private static final String PORT_DATABASE = "3306";
    private static final String NAME_DATABASE = "x_abs";
    
    private static Connection conn;
    
    public static Connection getConnection(){
        if(conn==null){
            String url = "jdbc:mysql://"+ HOST_DATABASE +":"+ PORT_DATABASE +"/"+ NAME_DATABASE;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url, USER_DATABASE, PASSWORD_DATABASE);
            }catch(Exception e){
                System.out.println("Connection failed...");
                e.printStackTrace();
            }
        }
        return conn;
    }
}
