//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.longestPalindrome(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String longestPalindrome(String S) {
    // Initialize variables to store the maximum length of palindrome found and its starting index
    int maxLen = 0;
    int start = 0;

    // Iterate through each character in the string
    for (int i = 0; i < S.length(); i++) {
        // Consider odd length palindromes centered at S[i]
        int len1 = expandAroundCenter(S, i, i);
        // Consider even length palindromes centered between S[i] and S[i+1]
        int len2 = expandAroundCenter(S, i, i + 1);
        // Determine the maximum length between odd and even length palindromes
        int len = Math.max(len1, len2);

        // If a longer palindrome is found, update maxLen and start
        if (len > maxLen) {
            maxLen = len;
            start = i - (len - 1) / 2;
        }
    }

    // Return the longest palindrome substring
    return S.substring(start, start + maxLen);
}

// Helper method to expand around the center and find the length of the palindrome
int expandAroundCenter(String s, int left, int right) {
    // Expand as long as the characters on both sides are equal
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        left--;
        right++;
    }
    // Return the length of the palindrome
    return right - left - 1;
}

    
}