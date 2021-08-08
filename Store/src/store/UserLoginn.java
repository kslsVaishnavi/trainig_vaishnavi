package store;
import java.io.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import java.util.Map.Entry;





//public class UserLoginn {public class Store{


	

	public class UserLoginn {
		/*private static Connection connection = null;
	    private static Statement stmt = null;
  
	    private static void createConnection()
	    {
	        try
	        {
	       //     Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
	            //Get a connection
	        //    conn = DriverManager.getConnection(dbURL);
	        	Class.forName("org.apache.derby.jdbc.ClientDriver");
				connection = DriverManager.getConnection("jdbc:derby://localhost:1527/sample1;create=true","user","user");
				
	        }
	        catch (Exception except)
	        {
	            except.printStackTrace();
	        }
	    }*/
	    
	    /*private static void insertInvoicedetails(String userid, String product,float quantInt,float finalTotalAmount)
	    {
	        try
	        {
	            //stmt = connection.createStatement();
	            PreparedStatement st = connection.prepareStatement("insert into app.InvoiceService values(?,?,?,?)");
				String query ="INSERT INTO APP.INVOICEDETAILS values('"+userid+"','"+product+"',"+quantInt+","+finalTotalAmount+")";	            
	            System.err.println(query);
	                 stmt.executeUpdate(query);
	                 System.out.println("Values inserted");
	            stmt.close();
	        }
	        catch (SQLException sqlExcept)
	        {
	            sqlExcept.printStackTrace();
	        }
	    }
	    */
		@SuppressWarnings("resource")
		public
				Scanner sc = new Scanner(System.in);
				Map<String,String> map = new HashMap<>();
				Map<String,String> map_1 = new HashMap<>();
			
				
			void login()
			{
			System.out.print(" UserName : ");
				String use = sc.nextLine();
				System.out.print(" Password: ");
				String pass = sc.nextLine();
				if(map.size()==0) {try {
	                throw new MyException("please register before login");
	            } catch (Exception e) {
	                System.out.println(e.getMessage());
	            }		 
					//System.out.println("incorrect");
				}
				else
				{  
					if(map.containsKey(use))
					{
						String check = map.get(use);
						if(pass.equals(check))
						{
							System.out.println("Login Successfully");
						
							store1(use);
						}
						else
							System.err.println("Invalid Password Or Username");

					}
				}
				
			}
			void register() {
				
			    	System.out.println("Enter user name:");
				String str_1=sc.nextLine();
				if(map.containsKey(str_1))
				{
					System.out.println("User Already Exist:");
				
				}
				else
				{
					System.out.println("Enter password:");
					String str2=sc.nextLine();
				  System.out.println("Enter role:");
					System.out.println("admin");
					System.out.println("user");
					System.out.println("manager");
					String str3=sc.nextLine();
					map.put(str_1,str2);
					map_1.put(str_1,str3);
					System.out.println("User Register Successfully");
					//System.out.println("User size :"+map.size());
					
				}
			}
			
			void invoiceDetails(String product, int quantInt, float originalBill, String userId)
			{
				Connection con = null;
				Statement stmt = null;
				try
		        {
					try{
						Class.forName("org.apache.derby.jdbc.ClientDriver");
					}catch(Exception e){
						System.out.println(e);
					}
		            //stmt = connection.createStatement();
		            
					con = (Connection) DriverManager.getConnection("jdbc:derby://localhost:1527/sample1","user","user");
					System.out.println("Connection is created successfully:");
					stmt = (Statement) con.createStatement();
					//PreparedStatement st = con.prepareStatement("insert into APP.INVOICE values(?,?,?,?)");
					String query ="INSERT INTO APP.INVOICESERVICE values('"+userId+"','"+product+"','"+Integer.toString(quantInt)+"','"+Float.toString(originalBill)+"')";	            
		           // System.err.println(query);
		                 stmt.executeUpdate(query);
		                 System.out.println("Values inserted");
		            //stmt.close();
		        }
		        catch (SQLException sqlExcept)
		        {
		            sqlExcept.printStackTrace();
		        } catch(Exception ex){
		        	ex.printStackTrace();
		        } finally{
		        	try{
		        		if(stmt != null)
		        			con.close();
		        	}catch(SQLException se){}
		        	try{
		        		if(con!=null)
		        			con.close();
		        		
		        	}catch(SQLException se){
		        		se.printStackTrace();
		        	}
		        }
				System.out.println("Recored inserted");
			}			
			
			void store1(String userId)
			{
////				void cloth(){
//		    	System.out.println("Clothing store");
//		    }
	               String productType[]={"Jeans", "Shoes", "Shirts"};
			        String products[]={"A", "B", "C"};
			        float amount[]={100,200,300};
			        int quantitys[]={1,2,3};
			        
			       // public void store1(){
			       System.out.println("Hi There, Welcome to Clothing Store");
			       String gender;
			       String clothing;
			       String print;
			       Scanner scan = new Scanner(System.in);
			       System.out.println("Please select clothing for M/W:");
			           gender = scan.nextLine();
				       if( gender.equals("W")|| gender.equals("w")){
			    	         System.out.println("****Displaying Women Clothing****");
			    	         System.out.println("*         1 Jeans               *");
			    	         System.out.println("*         2 Shoes               *");
			    	         System.out.println("*         3 Shirts              *");
			    	         System.out.println("* Please choose clothing type:  *");
			    	         System.out.println("*********************************");
			    	         }
				       else if( gender.equals("M")|| gender.equals("m")){
			        	   System.out.println("****Displaying Men Clothing****");
			        	   System.out.println("*         1 Jeans               *");
			        	   System.out.println("*         2 Shoes               *");
			        	   System.out.println("*         3 Shirts              *");
			        	   System.out.println("* Please choose clothing type:  *");
			        	   System.out.println("*********************************");
			        	  }
				       else{try {
			                throw new MyException("choose gender between Men or Women");
			            } catch (Exception e) {
			                System.out.println(e.getMessage());
			            }		 
				    	   //System.out.println("gender not matched");
				       }
				       
				       clothing = scan.nextLine();
			           if(clothing.equals("1")|| clothing.equals("2")|| clothing.equals("3")){
			           System.out.println("---------------------------------------");
			           System.out.println("products       quantity        Amount");
			           System.out.println("---------------------------------------");
			           System.out.println("   A               1           100.00 ");
			           System.out.println("   B               2           200.00 ");
			           System.out.println("   C               3           300.00 ");
			           System.out.println("---------------------------------------");
			        }
			           else{try {
			                throw new MyException("select the correct clothing type from above");
			            } catch (Exception e) {
			                System.out.println(e.getMessage());
			            }clothing = scan.nextLine();
			            if(clothing.equals("1")|| clothing.equals("2")|| clothing.equals("3")){
					           System.out.println("---------------------------------------");
					           System.out.println("products       quantity        Amount");
					           System.out.println("---------------------------------------");
					           System.out.println("   A               1           100.00 ");
					           System.out.println("   B               2           200.00 ");
					           System.out.println("   C               3           300.00 ");
					           System.out.println("---------------------------------------");
					        }
			        	   //System.out.println("quantity not matched");
			           }
			           int quantTemp=0;
			           System.out.println("select product:");
			           String product = scan.nextLine();
			          System.out.println("select quantity:");
			           String quantity= scan.nextLine();
			           int quantInt =Integer.parseInt(quantity);
			           //float f=Float.parseFloat(amount);
			           float amountTemp =0; float finalTotalAmount=0;
			          
			           for(int i=0;i<=products.length;i++){
			        	   String productsTemp = products[i];
			        	   if(product.equals(productsTemp)){
			        		   quantTemp=quantitys[i];
			        		   amountTemp=amount[i];
			        		   
			        		  break;
			        		  }
			        	  }
			           finalTotalAmount= quantInt *amountTemp;
			           
			           
			       System.out.println("Invoice generated:");
				   System.out.println("-------------------------------");
				   System.out.println("products    quantity     Bill   ");
				   System.out.println("-------------------------------");
				   System.out.println(product+"         "+quantInt+"          "+finalTotalAmount  );
				   System.out.println("--------------------------------");
				   Bill bill = new Bill();
					float originalBill = bill.calculateBill(quantTemp, amountTemp);
					int gst = 0;
					if (finalTotalAmount > 100 && finalTotalAmount <= 200) {
						gst = 10;
					} else if (finalTotalAmount> 200 && finalTotalAmount <= 500) {
						gst = 20;
					} else if (originalBill > 500) {
						gst = 30;
					}
					float TotalBill = bill.calculateBill(quantTemp, amountTemp, gst);
					
					System.out.println("Total: " +TotalBill+ " (" + originalBill + " + " + gst + "% GST  "
							+ bill.calculateGst(originalBill, gst)+"Rs)");
			
				        System.out.println("Total: "+TotalBill);
					
				
	                   if(quantInt>quantTemp){try {
			                throw new MyException("select the correct product with respective quantity");
			            } catch (Exception e) {
			                System.out.println(e.getMessage());
			            }	
					  // System.out.println("INVALID QUANTITY");
					   }
	                   
	                  System.out.println("Do you want to print invoice :(y/n)");
	                  print=scan.nextLine();
	                  
	                  if(print.equals("y")|| print.equals("Y")){
	                	   try {
	                		   invoiceDetails(product, quantInt, originalBill, userId);
	                		   FileWriter fw= new FileWriter("invoice.txt");
	                		   fw.write("Invoice generated ::");
	                		   fw.write("\n-------------------------------");
	                		   fw.write("\nproducts   quantity     Bill");
	                		   fw.write("\n-------------------------------");
	                		   String Taken=(product+"         "+quantInt+"          "+finalTotalAmount  );
	                		   fw.write("\n");
	                		   fw.write(Taken);
	                		   fw.write("\n----------------------------------");
	                		   String Total=("Total: " +TotalBill+ " (" + originalBill + " + " + gst + "% GST  "
	           						+ bill.calculateGst(originalBill, gst)+"Rs)");
	                		   fw.write("\n");
	                		   fw.write(Total);
	                		   String FinalBill=("Total: "+TotalBill);
	                		   fw.write("\n");
	                		   fw.write(FinalBill);
	                		    fw.close();
	                	   }catch(IOException io){
	                		   
	                	   }
	                  }
			   }

			public static void main(String[] args) {
				UserLoginn obj = new UserLoginn();
				Scanner sc = new Scanner(System.in);
				System.out.println("choose the option 1 and 2:");
		while(true) {
					System.out.println("Login");
					System.out.println("Register");
				    int option=sc.nextInt();	
				
				switch(option)
				{
				case 1:
							
					System.out.println("Login");
					 obj.login();
					 
					break;
				case 2:
					System.out.println("Register");
					obj.register(); 
					break;
				
				default:try {
	                throw new MyException("select from login or register");
	            } catch (Exception e) {
	                System.out.println(e.getMessage());
	            }		         
		           //System.err.print("Invalid Input");
						
				}	
			}
	}
}

	class MyException extends Exception {
	    public MyException() {

	  }

	 

	    MyException(String message) {
	        super(message);
	    }
	}





