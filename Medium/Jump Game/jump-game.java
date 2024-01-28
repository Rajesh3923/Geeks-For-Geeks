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
        int maxReach = 0; // maximum index that can be reached
        for (int i = 0; i < N; i++) {
            if (i > maxReach) {
                // If the current index is not reachable
                // return 0 as we can't reach the end
                return 0;
            }
            // Update the maximum index that can be reached
            maxReach = Math.max(maxReach, i + A[i]);
            if (maxReach >= N - 1) {
                // If the maximum index that can be reached is greater
                // than or equal to the last index, return 1
                return 1;
            }
        }
        return 0;
    }
};