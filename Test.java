import java.util.*;

public class Test {
    static class Job{
        int id;
        int deadline;
        int profit;

        Job(int first, int second, int third){
            this.id = first;
            this.deadline = second;
            this.profit = third;
        }

    }

    public static void jobSequencing(Job[] jobs){
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int maxDeadline = Integer.MIN_VALUE;
        for(Job job: jobs){
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        Integer slots[] = new Integer[maxDeadline+1];
        Arrays.fill(slots, -1);

        int profit = 0;

        for(Job job:jobs){
            for(int i = job.deadline; i>0; i--){
                if(slots[i] == -1){
                    slots[i] = job.id;
                    profit += job.profit;
                    break;
                }
            }
        }

        System.out.println("Maximum profit = " + profit);
        System.out.print("Jobs Sequence = ");
        for(int element : slots){
        if(element != -1){
            System.out.print(element+" ");
        }
    }

    }
    
    public static void main(String[] args) {
        Job jobs[] = {
            new Job(1,2,100),
            new Job(2,1,50),
            new Job(3,2,10),
            
        };

        jobSequencing(jobs);
        int arr[] = {4,5,1,2,3};
        System.out.println(Arrays.toString(arr));
    }
}