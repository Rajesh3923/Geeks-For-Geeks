//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java
//Back-end complete function Template for Java
class Solution {
   public int alternatingMaxLength(int[] arr) {
    // Check if the array is empty, return 0 as the length of the good sequence
    if (arr.length == 0) return 0;
    
    // Initialize variables to keep track of the length of the longest increasing 
    // and decreasing subsequences.
    int up = 1;   // Length of the longest subsequence ending in a "up" (increase)
    int down = 1; // Length of the longest subsequence ending in a "down" (decrease)
    
    // Loop through the array starting from the second element
    for (int i = 1; i < arr.length; i++) {
        // If the current element is greater than the previous element
        if (arr[i] > arr[i - 1]) {
            // Update 'up' as 'down + 1' (because we can extend the longest 
            // "down" subsequence by this "up" move)
            up = down + 1;
        }
        // If the current element is smaller than the previous element
        else if (arr[i] < arr[i - 1]) {
            // Update 'down' as 'up + 1' (because we can extend the longest 
            // "up" subsequence by this "down" move)
            down = up + 1;
        }
        // If the current element is equal to the previous element, do nothing
        // because it does not help in extending any alternating subsequence.
    }
    
    // The length of the longest alternating sequence will be the maximum 
    // of 'up' and 'down'
    return Math.max(up, down);
}

}

//{ Driver Code Starts.

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int[] nums = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                nums[i] = Integer.parseInt(s[i]);
            }
            Solution obj = new Solution();
            int ans = obj.alternatingMaxLength(nums);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends