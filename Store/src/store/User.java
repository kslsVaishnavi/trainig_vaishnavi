package store;

//import java.io.*;
////import bill.Bill;
//import java.util.*;
//import java.util.Map.Entry;
//
//
//
//	class User extends store{
//				public class UserAuthentication {
//			public
//				Scanner sc = new Scanner(System.in);
//				Map<String,String> map = new HashMap<>();
//				Map<String,String> map_1 = new HashMap<>();
//			
//				
//			void login()
//			{
//				
//				System.out.print("Enter UserName : ");
//				String use = sc.nextLine();
//				System.out.print("Enter Password: ");
//				String pass = sc.nextLine();
//				if(map.size()==0) {
//					System.out.println(" User Not Present :");
//				}
//				else
//				{  
//					if(map.containsKey(use))
//					{
//						String check = map.get(use);
//						if(pass.equals(check))
//						{
//							System.out.println("        Login Successfully        ");
//							store();
//						}
//						else
//							System.err.println("   Invalid Password Or Username   ");
//
//					}
//				}
//			}
//			void register() {
//				
//			    	System.out.println("       Enter user name:     ");
//				String str_1=sc.nextLine();
//				if(map.containsKey(str_1))
//				{
//					System.out.println("User Already Exist:");
//				
//				}
//				else
//				{
//					System.out.println("         Enter password      ");
//					String str2=sc.nextLine();
//				  System.out.println("          Enter role:         ");
//					System.out.println("admin");
//					System.out.println("user");
//					System.out.println("manager");
//					 
//					String str3=sc.nextLine();
//					map.put(str_1,str2);
//					map_1.put(str_1,str3);
//					System.out.println("       User Register Successfully       ");
//					System.out.println("          User size :"+map.size()        );
//				}
//			}
//			
//		}
//	
//	
//	 public static void main(String[] args) {
//			UserAuthentication obj = new UserAuthentication();
//			Scanner sc = new Scanner(System.in);
//			System.out.println("        Please select option 1 and 2:         ");
//			System.out.println("   ");
//		      	System.out.println("                Hi            ");
//			
//			
//			while(true) {
//				System.out.println("            1.Login           ");
//				System.out.println("            2.Register        ");
//			    int option=sc.nextInt();	
//			
//			switch(option)
//			{
//			case 1:
//						
//				System.out.println("            Login              ");
//				 obj.login();
//				 
//				break;
//			case 2:
//				System.out.println("           Register             ");
//				obj.register(); 
//				break;
//			
//			default:
//				  System.err.print("          Invalid Input!         ");
//					
//			}
//			}	
//		}
//		}
//		 
//
//						
//				    
////		  
////		 static final String username = "vaishnavi";
////		 static final String password = "9192713";
////		static final String usertype = "admin";
////		public void store(){
////		   Scanner scan = new Scanner(System.in);
////			System.out.println("Hi!!");
////			System.out.println("1. Login");
////	        System.out.println("2. Register");
////	        System.out.println("Choose one of the option::");
////	        String option=scan.nextLine();
////	        if(option.equals("1")){
////			System.out.println("Please enter UserName::");
////			String Username=scan.nextLine();
////				System.out.println("Please enter Password::");
////				String Password=scan.nextLine();
////			          if(Username.equals("vaishu")&& Password.equals("2713")){
////					       System.out.println("valid");
////					   }
////			        else{
////						 System.out.println("Username or Password Incorrect");
////					 System.exit(1);
////					 }
////			  } 
////			          if(option.equals("2")){
////	 			 System.out.println("Register");
////	 			 System.out.println("Username:");
////		 			 String Username1=scan.nextLine();
////		 			 System.out.println("Password:");
////		 			 String Password1=scan.nextLine();
////	 			     System.out.println("choose role: admin/user/manager");
////		 			 String role =scan.nextLine();
////		 			 if(role.equals("admin")){
////		 				 System.out.println("choose different role");
////		 				System.out.println("choose role: admin/user/manager");
////	 				String role1 =scan.nextLine();
////		 				System.out.println("successful"); 
////		 			 	 }
////		 			 else if(role.equals("user")||role.equals("manager")){
////	 				 
////		 				System.out.println("successful");
////		 			 }
////		 			 }
////			          return;
////		 			 
////		 		 } 
////	          
////		    public static void main(String[] args){
////		   store obj1=new User();
////		   obj1.store();
////		   store obj2 = new store();
////		   obj2.store();
////		   }
////		    
////	         
////	   }
////	   
//	 
//      
//
//
//
//
//
//
//
//
