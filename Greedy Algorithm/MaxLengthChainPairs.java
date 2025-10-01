import java.util.*;

public class MaxLengthChainPairs{
	static class Pair{
		int first;
		int second;

		Pair(int first, int second){
			this.first = first;
			this.second = second;
		}
	}

	public static int maxChainLength(Pair pairs[]){
		// 1. Sort pairs by second value
		Arrays.sort(pairs, (a, b) -> a.second - b.second);

		// 2. Pick first pair
		int count = 1;
		int lastEnd = pairs[0].second;

		// 3. check for all pairs
		for(int i=0; i<pairs.length; i++){
			if(pairs[i].first > lastEnd){
				count++;
				lastEnd = pairs[i].second;
			}
		}

		return count;
	}

	public static void main(String[] args) {
        Pair[] pairs = {
            new Pair(5, 24),
            new Pair(15, 25),
            new Pair(27, 40),
            new Pair(50, 60)
        };

        System.out.println("Maximum length of chain = " + maxChainLength(pairs));
    }
}