/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class DbOperationConnection
{
   
  public static boolean  newBuyerConnection(String name,String contact_no,String email,String address,String gender)
  {
      boolean status=false;
       try
        {
             Connection con=ConnectionProvider.getConnection();
             
             
             PreparedStatement ps=con.prepareStatement("insert into buyer values(?,?,?,?,?)");
             ps.setString(1, name);
             ps.setString(2, contact_no);
             ps.setString(3, email);
             ps.setString(4, address);
             ps.setString(5, gender);
             
            int a= ps.executeUpdate();
            if(a>0)
            {
                status=true;
            }
            else
            {
               status=false;       
            }
             
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
       return status;
  }
  public static ResultSet searchforUdateBuyer(String Phone_no)
  {
      ResultSet rs = null;
      try
      {

                Connection con=ConnectionProvider.getConnection();

                 PreparedStatement ps=con.prepareStatement("Select * from buyer where contactNo=?");
                 ps.setString(1, Phone_no);
                 rs=ps.executeQuery();
                 

      }
      catch(Exception e)
      {
          System.out.println(e);
      }
      return rs;
  }
  public static boolean updateforUpdateBuyer(String name,String contact_no,String email,String address,String gender)
  {
      boolean status=false;
      try
      {
          Connection con=ConnectionProvider.getConnection();
          
          PreparedStatement ps=con.prepareStatement("update buyer set name=?,email=?,address=?,gender=? where contactNo=?");
          
          ps.setString(1, name);
          ps.setString(2, email);
          ps.setString(3, address);
          ps.setString(4, gender);
          ps.setString(5, contact_no);
          int a=ps.executeUpdate();
          
          if(a>0)
          {
            status= true;   
          }
          else
          {
              status=false;
          }
             
          
          
      }
      catch(Exception e)
      {
          System.out.println(e);
      }
       return status;
  }
  public static ResultSet printBuyerDetails()
  {
      ResultSet rs = null;
      try
      {
          Connection con=ConnectionProvider.getConnection();
          PreparedStatement ps=con.prepareStatement("Select * from buyer ");
              rs= ps.executeQuery();
      
      }
      catch(Exception e)
      {
          System.out.println(e);
      }
      return rs;
  }
  public static boolean deleteBuyers(String contact_Number)
  {
      boolean status=false;
      try
      {
          Connection con=ConnectionProvider.getConnection();
          
          PreparedStatement ps=con.prepareStatement("Delete from buyer where contactNo=?");
          
          ps.setString(1, contact_Number);
          
          int a=ps.executeUpdate();
          if(a>0)
          {
              status=true;
          }
          else
          {
              status=false;
          }
      }
      catch(Exception e)
      {
          System.out.println(e);
      }
      return status;
  }
  public static boolean saveNewProductDetails(int p_id,String p_name,int rate,String p_desription,String active )
  {
      boolean status=false;
      try
      {
          Connection con=ConnectionProvider.getConnection();
          
          PreparedStatement ps=con.prepareStatement("insert into product values(?,?,?,?,?)");
          
          ps.setInt(1, p_id);
          ps.setString(2, p_name);
          ps.setInt(3, rate);
          ps.setString(4, p_desription);
          ps.setString(5, active);
          
         int a= ps.executeUpdate();
         
         if(a>0)
         {
             status=true;
         }
         else
         {
             status=false;
         }
          
          
      }
      catch(Exception e)
      {
          System.out.println(e);
      }
      return status;
  }
    public static ResultSet searchProduct(String p_id)
    {
        ResultSet rs = null;
        try
        {
             Connection con=ConnectionProvider.getConnection();
        
             PreparedStatement ps=con.prepareStatement("select * from product where p_id=?");
             
             ps.setString(1, p_id);
             rs= ps.executeQuery();
             
             
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return rs;
    }
    public static boolean udateProduct(String p_name, String rate, String description,String activity, String p_id)
    {
        boolean status=false;
        try
        {
            Connection con=ConnectionProvider.getConnection();
            PreparedStatement ps=con.prepareStatement("update product set p_name=?,rate=?,description=?,active=? where p_id=?");
            
          
            ps.setString(1, p_name);
           ps.setString(2, rate);
           ps.setString(3, description);
           ps.setString(4, activity);
           ps.setString(5, p_id);
            int a=ps.executeUpdate();
            
            
            if(a>0)
            {
                status=true;
            }
            else
            {
                status=false;
            }
            
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return status;
    }
public static ResultSet productDetais()
{
    ResultSet rs = null;
    try
    {
        Connection con=ConnectionProvider.getConnection();
        PreparedStatement ps=con.prepareStatement("select *from product");
        rs=ps.executeQuery();
        
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
    return rs;
}
public static boolean deleteProduct(String p_id)
{
    boolean status = false ;
     try
     {
         Connection con=ConnectionProvider.getConnection();
         PreparedStatement ps=con.prepareStatement("delete from product where p_id=?");
         ps.setString(1, p_id);
         
         int a=ps.executeUpdate();
         if(a>0)
         { 
              status=true;
         }
         else
         {
             status=false;
         }
         
     }
     catch(Exception e)
     {
         JOptionPane.showMessageDialog(null, e);
     }
     return status;
}
    
    public static ResultSet searchforUdateBuyerByName(String name)
  {
      ResultSet rs = null;
      try
      {

                Connection con=ConnectionProvider.getConnection();

                 PreparedStatement ps=con.prepareStatement("Select * from buyer where name like '"+name+"%'");
                 
                 rs=ps.executeQuery();
                 

      }
      catch(Exception e)
      {
          System.out.println(e);
      }
      return rs;
  } 
    
}
