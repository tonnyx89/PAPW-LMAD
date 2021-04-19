/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author tonny
 */
public class Conexion {
    
    private String USERNAME = "root";
    private String PASSWORD = "123456";
    private String HOST = "localhost";
    private String PORT = "3306";
    private String DATABASE = "couturedb";
    private String CLASSNAME = "com.mysql.cj.jdbc.Driver";
    private String URL = "jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    Connection conn;
    
    public Conexion() {
        try{
            Class.forName(CLASSNAME);
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        catch(ClassNotFoundException | SQLException e){
            System.err.println("Error" +  e);
        }
    }
    
    
    public Connection getConexion(){
        return conn;
    }
    
  
}
