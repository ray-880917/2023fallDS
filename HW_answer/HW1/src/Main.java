
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in)); 
		System.out.print("Please enter your weight(kg) and height(cm): "); 
		String text = buf.readLine(); 
		String[] data = text.split(" ");
		double res = getBMI(data);
		String dia = getDiagnosis(res);
		System.out.println(dia + " BMI: " + res);               
	}
	
	public static double getBMI(String[] data) {
		// 1. calculate the bmi 
		double bmi = Double.parseDouble(data[0]) / (Double.parseDouble(data[1])/100)/ (Double.parseDouble(data[1])/100);
		
		return bmi;
	}
	
	public static String getDiagnosis(double bmi) {
		// 2. give comments depending on bmi
		String res="";
		if(bmi>=30)
		{
			res="You are not in shape. Actually, you are not even close.";
		}
		else if(bmi>=26)
		{
			res="To be honest, you are not in shape.";

		}
		else if(bmi>=20)
		{
			res="You are in shape.";
		}
		else
		{
			res="You are under shape";
		}
        return res;
	}
}
