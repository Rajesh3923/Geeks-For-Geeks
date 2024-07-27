//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.countMin(str));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
     static int countMin(String str) {
        int n = str.length();
        // dp[i][j] represents the minimum number of operations to make the substring str[i...j] a palindrome
        int[][] dp = new int[n][n];
        
        // Base case: Single character substrings are already palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }
        
        // Fill the table for substrings of length 2 to n
        for (int len = 2; len <= n; len++) { // len is the length of the current substring
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1; // Ending index of the current substring
                if (str.charAt(i) == str.charAt(j)) {
                    // If the characters at the ends are the same, no new operation needed
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    // If the characters at the ends are different, 1 operation needed
                    // Choose the minimum operations needed between the two possibilities
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // The answer for the entire string is found at dp[0][n-1]
        return dp[0][n - 1];
    }
}