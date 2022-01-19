/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author user
 */
public class ConnectionProvider
{
    static Connection con;
    public static Connection getConnection()
    {
        
       try
       {
            Class.forName("com.mysql.cj.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Billing_ManagementSystem", "root", "root");
          
       }
       catch(Exception e )
       {
           System.out.println(e);
       }
       return con;
    }
    
}
