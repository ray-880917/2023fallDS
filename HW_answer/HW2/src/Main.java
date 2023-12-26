import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Please type (1)type and (2)number of initial people or capital and (3)years");
		Scanner sc = new Scanner(System.in);
			try {
				while(sc.hasNext()) {
					int type = sc.nextInt();
					
					switch(type){					
						case 0: //population
							// 1. get user input 
							int people = sc.nextInt();
							int prate = 2 ;
							GeomProgression<Integer> Population = new GeomProgression<Integer>(people, prate);
							Population.printProgression((sc.nextInt()/30+1));
							break;
							
						case 1: //capital
							// 1. get user input
							Double initial = sc.nextDouble();
							Double crate = 1.026;
							GeomProgression<Double> Capital = new GeomProgression<Double>(initial,crate);
							Capital.printProgression(sc.nextInt()+1);
							break;
							
						default:
							throw new Exception("InvalidType please enter type for 0 or 1");
					}
				}		
				
			}catch(Exception e) {
				System.out.println("Error: "+e.getMessage());
			}
			
		sc.close();
	}
}