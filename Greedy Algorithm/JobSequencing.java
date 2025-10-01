import java.util.*;

public class JobSequencing{
	static class Job{
		int id, deadline, profit;

		Job(int id, int deadline, int profit){
			this.id = id;
            this.deadline = deadline;
            this.profit = profit;
		}
	}

	public static void jobSequencing(Job[] jobs){

		// 1. Sort jobs by profit (descending)
		Arrays.sort(jobs, (a, b) -> b.profit - a.profit);


		// 2. Find maximum deadline
		int maxDeadline = 0;
		for(Job job : jobs){
			maxDeadline = Math.max(maxDeadline, job.deadline);
		}


		// 3. Time slot (init wit -1)
		int [] slot = new int[maxDeadline+1];  // because array is 0 based indexed, we need 1 based
		Arrays.fill(slot, -1);

		
		int profit = 0;

		// 4. Scheduel jobs
		for(Job job : jobs){
			//find free slow from job.deadline to 1
			for(int j = job.deadline; j>0; j--){
				if(slot[j] == -1){  // slot available for scheduling
					slot[j] = job.id;
					profit += job.profit;
					break;
				}
			}
		}

        System.out.println("Maximum profit = " + profit);
        System.out.print("Jobs Sequence = ");
        for(int element : slot){
        	if(element != -1){
        		System.out.print(element+" ");
        	}
        }
	}

	public static void main(String[] args) {
        Job[] jobs = {
            new Job(1, 2, 100),
            new Job(2, 1, 50),
            new Job(3, 2, 10),
            
        };

        jobSequencing(jobs);
    }
}