/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author toshiba
 */
public class DataSource {
    
    
      
    private String url="jdbc:mysql://localhost:3306/pidev";
    private String login="root";
    private String pwd="";
    private static  DataSource d;
    private Connection conn;
    
    
   
    private DataSource()
    {
        
        try {
            conn=DriverManager.getConnection(url, login, pwd);
        } catch (SQLException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    public static  DataSource getInstance ()
    
    {
    if (d==null)
        d=new DataSource();
    return d;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public static DataSource getD() {
        return d;
    }

    public static void setD(DataSource d) {
        DataSource.d = d;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
    
    
    
    
    
    
    
}
