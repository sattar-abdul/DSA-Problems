import java.util.*;

public class ActivitySelection{
	public static void printMaxActivity(int start[], int end[]){

		ArrayList<Integer> ans = new ArrayList<>(); // to keep the index of selected acitvity
		int countAct = 0;
		
		int activities[][] = new int[start.length][3];
		for(int i=0; i<start.length; i++){
			activities[i][0] = i;
			activities[i][1] = start[i];
			activities[i][2] = end[i];
		}

		// Lambda function to sort activites acc to end
		Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));


		// add first act (according to end array)
		ans.add(activities[0][0]);
		countAct++;

		int lastEnd = activities[0][2];
		for(int i=1; i<start.length; i++){
			
			if(activities[i][1] >= lastEnd){        // start of next act >= end of prev act
				countAct++;
				ans.add(activities[i][0]);
				lastEnd = activities[i][2];
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