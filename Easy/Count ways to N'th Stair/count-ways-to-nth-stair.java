//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total testcases
        int t = sc.nextInt();

        while (t-- > 0) {

            // taking total number of stairs
            int n = sc.nextInt();

            // creating an object of class DynamicProgramming
            Solution obj = new Solution();

            // calling method of class countWays()
            // of class DynamicProgramming
            System.out.println(obj.countWays(n));
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to count number of ways to reach the nth stair
    // when order does not matter.
    Long countWays(int n) {
        long [] a=new long[n];
        if(n==1)return 1L;
        if(n==2)return 2L;
        a[0]=1;
        a[1]=2;
        for(int i=2;i<n;i++){
            if((i+1)%2==0){
                a[i]=Math.min(a[i-1],a[i-2])+1;
            }
            else{
                a[i]=Math.max(a[i-1],a[i-2]);
            }
        }
        return a[n-1];
    }
}
