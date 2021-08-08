package store;



//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.Scanner;

public class Bill {
				
				
				float calculateBill(float quantity,float price)
				{
					float amount= quantity*price;
					return amount;
					 
				}
				
				float calculateBill(float quantity,float price,int gst) {
					float amount = calculateBill(quantity, price);
					return amount+=(amount*gst/100);
				}
				
				float calculateGst(float amount,int gst) {		
					return (amount*gst/100);
				}
				}




