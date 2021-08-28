package Cloth;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Pay extends UserLoginn {
	Scanner sc = new Scanner(System.in);
	//private Object connect;
	
	public void Payment(String use){
		System.out.println("Select the options:");
		System.out.println("1. Credit Card Payment");
		System.out.println("2. Debit Card Payment");
		
		 
		int options=sc.nextInt();
		
		switch(options)
		{
		case 1:
					
			//System.out.println("Credit Card Payment");
			CreditCard(use, use);
			break;
		case 2:
			//System.out.println("Debit Card Payment");       
			DebitCard(use, use);
			break;
		
		default:try {
            throw new MyException("Select from Credit Card or Debit Card");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }		  
	}
		
	}
	
	
	
public static void CreditCard(String username,String TotalBill)  {
	 try{
		int bilInt = Integer.parseInt(TotalBill);
		Class.forName("org.apache.derby.jdbc.ClintDriver");
		Connection connect = DriverManager.getConnection("jdbc:derby://localhost:1527/sample1;create=true","user","user");
	        Statement stat = connect.createStatement();
		ResultSet rs= stat.executeQuery("SELECT * FROM APP.PAYMENT where userid='"+username+"'");
		rs.next();
		String d =rs.getString(2);
		int savings = Integer.parseInt(d);
		int balance = savings-bilInt;
		PreparedStatement ss = connect.prepareStatement("update APP.PAYMENT set creditcard=? where userid=?");
		ss.setInt(1, balance);
		ss.setString(2, username);
		ss.executeUpdate();
		if(balance>=0 && savings>=bilInt){
			
			System.out.println("transaction is done");
		}
		else{
			
			System.out.println("Credit limit is breached");
			System.out.println("Transaction Declined");
			System.exit(1);
		}
		connect.close(); 
	}catch(ClassNotFoundException  |SQLException e){
		System.out.println("Try to restart ");
		
	}
}

	public static void DebitCard(String username,String TotalBill)  {
		try{
			int bilInt = Integer.parseInt(TotalBill);
			Class.forName("org.apache.derby.jdbc.ClintDriver");
			Connection connect = DriverManager.getConnection("jdbc:derby://localhost:1527/sample1;create=true","user","user");
			Statement stat = connect.createStatement();
			ResultSet rs= stat.executeQuery("SELECT * FROM APP.PAYMENT where userid='"+username+"'");
			rs.next();
			String d =rs.getString(3);
			int savings = Integer.parseInt(d);
			int balance = savings-bilInt;
			System.out.println(balance);
			PreparedStatement ss = connect.prepareStatement("update APP.PAYMENT set Creditcard=? where userid=?");
			ss.setInt(1, balance);
			ss.setString(2, username);
			ss.executeUpdate();
			if(balance>=0 && savings>=bilInt){
				
				System.out.println("transaction is done");
			}
			else{
				System.out.println("Insufficient Balance");
				System.out.println("Transaction Declined");
				System.exit(1);
			}
			connect.close();
		}catch(ClassNotFoundException  | SQLException e ){
			System.out.println("Try to restart");
			
		}
	}
}














