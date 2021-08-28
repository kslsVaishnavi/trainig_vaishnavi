package Cloth;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public  class ProductService extends UserLoginn {
	private static final String NAME = null;
	static int duplicate = 0;
	Scanner sc = new Scanner(System.in);
	private Object connection;
	
	public void productService(String use) {
		System.out.println("Select the options:");
		System.out.println("1. Import product data");
		System.out.println("2. Check product data");
		System.out.println("3. Check invoice");
		 
		int admin_options=sc.nextInt();
		
		switch(admin_options)
		{
		case 1:
					
			System.out.println("Import product data");
			Data_Import(use);
			break;
		case 2:
			System.out.println("Check product data");       
			Data(use);
			break;
		
		case 3:
			System.out.println("Check invoice");
			store1(use);
			break;
			
		default:try {
            throw new MyException("select from login or register");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }		  
	}
}

public void Data_Import(String use) {
 Connection connection = null;
             try {
        	connection = (Connection) DriverManager.getConnection("jdbc:derby://localhost:1527/sample1","user","user");
            connection.setAutoCommit(false);
            BufferedReader lineReader = new BufferedReader(new FileReader("D:/workspace/Clothing/src/Cloth/products.csv"));
            String lineText = "";
            lineReader.readLine();
            while ((lineText = lineReader.readLine()) != null) {
                String[] data = lineText.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String gender = data[2];
                String brand = data[3];
                String cat = data[4];
                int quantity = Integer.parseInt(data[5]);
                int price= Integer.parseInt(data[6]);
                String status="Avilable Stock";
                if(quantity==0){
                	System.err.println("Out of Stock");
                }
                Statement stmt = (Statement) connection.createStatement();
                String query = "INSERT INTO APP.PRODUCTS(ID, NAME, GENDER, BRAND, CATEGORY, QUANTITY, PRICE,  STATUS) VALUES ("+id+",'"+name+"', '"+gender+"', '"+brand+"', '"+cat+"', "+quantity+", "+price+", '"+status+"')";
                stmt.executeUpdate(query);
                stmt. close();
               }
           lineReader.close();
            connection.commit();
            connection.close();
            System.out.println("Susscesfully Inserted");
        } catch (IOException ex) {
            System.err.println(ex);
        } catch (SQLException ex) {
            ex.printStackTrace();
 
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        productService(use);
	}
public void Data(String use){
	Connection connection = null;

    try {
        connection = DriverManager
                .getConnection("jdbc:derby://localhost:1527/sample1","user","user");
    } catch (SQLException e) {
        
        }
   if (connection != null) {
        System.out.println("Connected to database!");
    } else {
        System.out.println("Failed to make connection!");
    }

    try {
        Statement stmt = connection.createStatement();
        String query = "select * from APP.PRODUCTS ";
        ResultSet rs = stmt.executeQuery(query);
        System.out.println("---------------------------");
        while (rs.next()) {
        	
        	String id = rs.getObject(1).toString();
            String name = rs.getObject(2).toString();
            String gender = rs.getObject(3).toString();
            String brand = rs.getObject(4).toString();
            String category = rs.getObject(5).toString();
            String quantity = rs.getObject(6).toString();
            String price = rs.getObject(7).toString();
            String status = rs.getObject(8).toString();
            System.out.println("  "+ id + "--------" + name + "------" + gender + "--------" + brand + "--------" + category + "-----" + quantity + "-----" + price + "-------" + status + "  ");
      }
    } catch (SQLException e) {
        e.printStackTrace();
        for(Throwable ex : e) {
            System.err.println("Error occurred " + ex);
        }
        System.out.println("Error in fetching data");
    }
}	
 class Service {
  public void main(String[] args){
	  ProductService obj1= new ProductService();
	  obj1.store1(null);
	  
  }
 }
}



	






















































