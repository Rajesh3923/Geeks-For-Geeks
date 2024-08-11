//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends





class Solution {
    /**
     * Function to find the maximum profit and the number of jobs done.
     * @param arr Array of Job objects
     * @param n Number of jobs (not used in the implementation)
     * @return Array where index 0 contains maximum profit and index 1 contains number of jobs scheduled
     */
    public int[] JobScheduling(Job[] arr, int n) {
        // Step 1: Sort jobs by profit in descending order
        Arrays.sort(arr, (x, y) -> Integer.compare(y.profit, x.profit));

        // Step 2: Find the job with the maximum deadline
        int maxDeadline = 0;
        for (Job job : arr) {
            if (job.deadline > maxDeadline) {
                maxDeadline = job.deadline;
            }
        }

        // Step 3: Create an array 'a' to store profits scheduled at each deadline slot
        int[] a = new int[maxDeadline + 1]; // Initialize array 'a' with length maxDeadline + 1
        int totalProfit = 0;
        int jobsScheduled = 0;

        // Step 4: Schedule jobs to maximize profit
        for (Job job : arr) {
            int index = job.deadline;

            // Find the latest available slot for the job
            while (index > 0 && a[index] != 0) {
                index--;
            }

            // If a suitable slot is found, schedule the job
            if (index > 0) {
                a[index] = job.profit;
                totalProfit += job.profit;
                jobsScheduled++;
            }
        }

        // Step 5: Return the results in an array
        return new int[]{jobsScheduled,totalProfit};
    }

   
}

// class Job {
//     int id, profit, deadline;

//     Job(int id, int deadline, int profit) {
//         this.id = id;
//         this.deadline = deadline;
//         this.profit = profit;
//     }
// }


