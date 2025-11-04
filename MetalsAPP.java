package MetalsAPP;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;
public class MetalsAPP {
	static Scanner userinput = new Scanner(System.in);
	// convert to celcius
	static double convertToCelcius(String from, double temp) {
		double answer = temp;
		if (from.charAt(0) == 'f') {
			answer = (5.0 / 9) * (answer - 32);
		}
		if (from.charAt(0) == 'r') {
			answer = (5.0 / 9) * (answer - 492);
		}
		if (from.charAt(0) == 'k') {
			answer = answer - 273;
		}
		return answer;
	}
	// convert from celcius
	static double convertFromCelcius(String to, double temp) {
		double answer = temp;
		if (to.charAt(0) == 'f') {
			answer = Math.round(((9.0 / 5) * answer + 32)*100.0)/100.0;
		}
		if (to.charAt(0) == 'r') {
			answer = (9.0 / 5) * answer + 492;
		}
		if (to.charAt(0) == 'k') {
			answer = answer + 273;
		}
		return answer;
	}
	public static void main(String[] args) {
		double temp;
		double newTemp;
		String name;
		double density;
		double melt;
		double boil;
		double hardness;
		String fromM, toM;
		String cont="y";
		int i=0;
		// create the list array and add the metal info to it
		Object [][] metalTable=new Object[10][5];
		while (!(cont.charAt(0) == 'n')) {
			ArrayList<Object> metal=new ArrayList<>();
			System.out.print("Enter the name of your metal (You can enter up to 10)");
			name=userinput.nextLine();
			metal.add(name);
			System.out.print("Enter the density of your metal (g/cm^3)");
			density=userinput.nextDouble();
			metal.add(density);
			userinput.nextLine();
			System.out.print("Enter the melting point of your metal (degrees C)");
			melt=convertFromCelcius("f",userinput.nextDouble());
			metal.add(melt);
			userinput.nextLine();
			System.out.print("Enter the boiling point of your metal (degrees C)");
			boil=convertFromCelcius("f",userinput.nextDouble());
			metal.add(boil);
			userinput.nextLine();
			System.out.print("Enter the hardness of your metal (number 0-10)");
			hardness=userinput.nextDouble();
			metal.add(hardness);
			for (int j=0;j<5;j++) {
				metalTable[i][j]=metal.get(j);
			}
			System.out.println();
			i++;
			System.out.print("\nAnother Metal Addition (y or n)?");
			cont = userinput.next();
			userinput.nextLine();
		}				
		// print the metal information 
		System.out.print("Name       Density  Melting Point (F)  Boiling Point "
				+ "(F)  Hardness\n");
		for (int b=0;b<i;b++) {
			for (int g=0;g<5;g++) {
				System.out.print(metalTable[b][g]+"      ");
				if (g>0) {
					System.out.print("       ");
				}
			}
			System.out.println();
		}
		System.out.println("Thanks for using Temp Converter.");

	}

}
