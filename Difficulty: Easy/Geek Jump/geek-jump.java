//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
                
            }
            Solution obj=new Solution();
            int res=obj.minimumEnergy(arr,N);
            System.out.println(res);
            
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
   public int minimumEnergy(int[] arr, int N) {
        int[] dp = new int[N];
        Arrays.fill(dp, -1);
        return helper(arr, N - 1, dp);
    }

    public static int helper(int[] a, int n, int[] dp) {
        if (n == 0) return 0; // Base case: no energy needed to stay on the first stone
        if (dp[n] != -1) return dp[n];

        int left = helper(a, n - 1, dp) + Math.abs(a[n] - a[n - 1]);
        int right = Integer.MAX_VALUE;
        if (n > 1) {
            right = helper(a, n - 2, dp) + Math.abs(a[n] - a[n - 2]);
        }

        dp[n] = Math.min(left, right);
        return dp[n];
    }
}