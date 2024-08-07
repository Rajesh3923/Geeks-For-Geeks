//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S1[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            
            for(int i=0; i<N; i++)
                A[i] = Integer.parseInt(S1[i]);

            Solution ob = new Solution();
            System.out.println(ob.canReach(A,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int canReach(int[] A, int N) {
        int maxReach = 0;  // Initialize the maximum reachable index
        for (int i = 0; i < N; i++) {
            // If the current index is beyond the furthest reachable index, return 0 (false)
            if (i > maxReach) {
                return 0;
            }
            // Update the furthest reachable index
            maxReach = Math.max(maxReach, i + A[i]);
            // If the furthest reachable index is beyond or at the last index, return 1 (true)
            if (maxReach >= N - 1) {
                return 1;
            }
        }
        // If we exit the loop without reaching the last index, return 0 (false)
        return 0;
    }

  
}
