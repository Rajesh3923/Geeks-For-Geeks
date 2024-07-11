//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            
            int arr[] = new int[n];
            int dep[] = new int[n];
            
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
              arr[i] = Integer.parseInt(str[i]);
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                dep[i] = Integer.parseInt(str[i]);
                
            System.out.println(new Solution().findPlatform(arr, dep, n));
        }
    }
    
    
}



// } Driver Code Ends




//User function Template for Java

class Solution {
    // Function to find the minimum number of platforms required at the railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n) {
        // Sort the arrival and departure times
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        // Initialize pointers for arrival and departure times
        int i = 1, j = 0;
        // Initialize variables to keep track of platforms needed and the result
        int platforms_needed = 1, max_platforms = 1;
        
        // Iterate over arrival and departure times
        while (i < n && j < n) {
            // If the next event is an arrival, increment platforms_needed
            if (arr[i] <= dep[j]) {
                platforms_needed++;
                i++;
            } else { // If the next event is a departure, decrement platforms_needed
                platforms_needed--;
                j++;
            }
            // Update max_platforms if needed
            max_platforms = Math.max(max_platforms, platforms_needed);
        }
        
        return max_platforms;
    }
}

