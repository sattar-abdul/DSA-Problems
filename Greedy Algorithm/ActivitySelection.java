import java.util.*;

public class ActivitySelection{
	public static void printMaxActivity(int start[], int end[]){

		ArrayList<Integer> ans = new ArrayList<>(); // to keep the index of selected acitvity
		int countAct = 0;
		

		// add first act (according to end array)
		ans.add(0);
		countAct++;

		int lastEnd = end[0];
		for(int i=1; i<end.length; i++){
			
			if(start[i] >= lastEnd){        // start of next act >= end of prev act
				countAct++;
				ans.add(i);
				lastEnd = end[i];
			}
		}

		System.out.println("Max activities = " + countAct);
		System.out.println("Activities are = " + ans);
	}

	public static void main(String[] args) {
		int start[] = {1,3, 0, 5, 8, 5};
		int end[] = {2, 4, 6, 7 ,9, 9};   // already sorted given
		printMaxActivity(start, end);
	}
}