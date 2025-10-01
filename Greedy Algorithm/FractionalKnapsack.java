import java.util.*;

public class FractionalKnapsack{
	static class Item {
		int value, weight;
		double ratio;

		Item(int value, int weight){
		this.value = value;
		this.weight = weight;
		this.ratio = (double)value / weight;
		}
	}

	

	public static double getMaxValue(int value[], int weight[], int W){
		int n = value.length;
		Item[] items = new Item[n];

		// create item object
		for(int i=0; i<n; i++){
			items[i] = new Item(value[i], weight[i]);
		}

		// sort by ratio (descending)
		Arrays.sort(items, (a,b) -> Double.compare(b.ratio, a.ratio));

		double totalValue = 0.0;
		int currWeight = 0;

		for(Item item : items){
			if(currWeight + item.weight <= W){
				// Take whole Item
				currWeight += item.weight;
				totalValue += item.value;
			} else {
				// Take fraction of item
				int remain = W - currWeight;
				totalValue += item.value *((double)remain/item.weight);
				break;
			}
		}
		return totalValue;
	}

	public static void main(String[] args) {
        int[] value = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int W = 50;

        double result = getMaxValue(value, weight, W);
        System.out.println("Maximum value in Knapsack = " + result);
    }
}