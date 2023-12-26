import java.io.IOException;

public class Main 
{
	public static void main(String[] args) 
	{
		try 
		{
			/*
			 * Using different keyword depends on the last number of your student ID
			 * 0,1:Tomato
			 * 2,3:Process
			 * 4,5:Twitter
			 * 6,7:Liver
			 * 8,9:Tissue
			 */
			System.out.println(new GoogleQuery("Process").query());
//			GoogleQuery g =new GoogleQuery("NCCU");
//			g.query();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
