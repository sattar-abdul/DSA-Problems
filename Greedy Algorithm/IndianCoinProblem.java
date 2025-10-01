import java.util.*;

public class IndianCoinProblem {
	public static void main(String[] args){

		Integer[] coins = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
		

		// 1. sort denomination in descending order
		Arrays.sort(coins, (b, a) -> a - b);

		// 2. user input
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter amount: ");
		int value = sc.nextInt();

		// 3. keeping track of coins given
		List<Integer> usedCoins = new ArrayList<>();
		int count = 0; // count coins/notes		


		// 4. Choose largest denomination <= remaining value
		for(int coin : coins){
			while(coin <= value){
				value -= coin;
				usedCoins.add(coin);
				count++;
			}
		}

		System.out.println("Minimum number of coins/notes = " + count);
        System.out.println("Coins/notes used: " + usedCoins);
	}
}