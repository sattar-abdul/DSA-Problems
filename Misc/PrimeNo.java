public class PrimeNo{
	public static boolean isPrime(int n){
		if(n<=1){
			return false;
		}

		// check if n is divisible by 2 to n-1
		for(int i = 2; i<n; i++){
			if(n%i==0){
				return false;
			}
		}
		return true;

	}

	public static boolean isPrimeOptimized(int n){
		if(n<=1){
			return false;
		}

		/*  Check for divisibility from 2 up to the square root of the number.
        	If a number has a divisor greater than its square root, it must
            also have one less than its square root. 
        */
		for(int i = 2; i<Math.sqrt(n); i++){

			if(n%i==0){
				return false;
			}
		}
		return true;

	}

	public static void main(String[] args) {
    
        System.out.println(isPrime(1));
        System.out.println(isPrime(2));
        System.out.println(isPrime(3));

        System.out.println(isPrimeOptimized(1));
        System.out.println(isPrimeOptimized(2));
        System.out.println(isPrimeOptimized(3));


	}
}