import java.util.*;

public class MinimumCostToCutChocolate{
	public static int minCost(int[] horizontal, int[] vertical) {

		// 1. sort cost arrays
		Arrays.sort(horizontal);
		Arrays.sort(vertical);

		// 2. taking reverse order (highest cost first)
		int h = horizontal.length-1;
		int v = vertical.length-1;


		int hp = 1, vp = 1; // no of vertical and horzontal pieces
		int cost = 0;


		// 3. Calculate cost of cutting
		while(h>=0 && v>=0){
			if(horizontal[h] >= vertical[v]){
				cost += horizontal[h] * vp;
				h--;
				hp++;
			} else {
				cost += vertical[v] * hp;
				v--;
				vp++;
			}
		}

		// Remaining horizontal cuts (if any)
		 while (h >= 0) {
            cost += horizontal[h] * vp;
            hp++;
            h--;
        }


		// Remaining vertical cuts (if any)
		 while (v >= 0) {
            cost += vertical[v] * hp;
            vp++;
            v--;
        }

        return cost;
	}

	public static void main(String[] args) {
        int[] horizontal = {3};     
        int[] vertical   = {2};

        System.out.println("Minimum cost = " + minCost(horizontal, vertical));
    }

}