import java.util.*;

public class BinaryToDecimal{

	public static int binaryToDecimal(String binary){
		int decimal = 0;
		int power = 0;
		for(int i = binary.length()-1; i>=0; i--){
			if(binary.charAt(i) == '1'){
				decimal += Math.pow(2, power);
			}
			power++;
		}
		return decimal;
	}


	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a Binary number: ");
		String binary = sc.nextLine();

		// Binary -> Decimal Using built in Method
		int number = Integer.parseInt(binary, 2); 
		System.out.println("Decimal number using built-in method: "+number);


		// Binary -> Decimal Using custom method
		number = binaryToDecimal(binary); 
		System.out.println("Decimal number using custom method: "+number);
	}
}