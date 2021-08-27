package Cloth;


	import java.io.FileWriter;
	//import java.io.IOException;
	//import java.util.Scanner;

	
					
	public class Billing {
					float calculateBilling(float quantity,float price)
					{
						float amount= quantity*price;
						return amount;
						 
					}
					
					float calculateBilling(float quantity,float price,int gst) {
						float amount = calculateBilling(quantity, price);
						return amount+=(amount*gst/100);
					}
					
					float calculateGst(float amount,int gst) {		
						return (amount*gst/100);
					}
					



}


