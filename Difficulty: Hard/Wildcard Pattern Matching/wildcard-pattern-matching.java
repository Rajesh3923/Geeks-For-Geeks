//{ Driver Code Starts
import java.util.*;

class WildcardPattern {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String pat = sc.nextLine();
            String text = sc.nextLine();
            Solution g = new Solution();
            System.out.println(g.wildCard(pat, text));
            t--;
        }
    }
}
// } Driver Code Ends


// // below is recursive approach ----

// class Solution {
//     public int wildCard(String pattern, String str) {
//         int n = pattern.length();
//         int m = str.length();
//         return f(n - 1, m - 1, pattern, str) ? 1 : 0;
//     }

//     private boolean f(int i, int j, String pattern, String text) {
//         // Base case: both pattern and text are fully matched
//         if (i < 0 && j < 0) return true;

//         // Base case: pattern is empty but text is not (no match)
//         if (i < 0 && j >= 0) return false;

//         // Base case: text is empty but pattern still has characters
//         if (i >= 0 && j < 0) {
//             // The remaining pattern should only contain '*'
//             for (int ii = 0; ii <= i; ii++) {
//                 if (pattern.charAt(ii) != '*') return false;
//             }
//             return true;
//         }

//         // Case 1: pattern character matches the text character or is '?'
//         if (pattern.charAt(i) == text.charAt(j) || pattern.charAt(i) == '?') {
//             return f(i - 1, j - 1, pattern, text);
//         }

//         // Case 2: pattern character is '*'
//         if (pattern.charAt(i) == '*') {
//             // Try two possibilities:
//             // 1. Treat '*' as an empty sequence -> move in pattern
//             // 2. Treat '*' as a non-empty sequence -> move in text
//             return f(i - 1, j, pattern, text) || f(i, j - 1, pattern, text);
//         }

//         // Case 3: pattern and text characters do not match
//         return false;
//     }
// }




class Solution {
    public int wildCard(String pattern, String str) {
        int n = pattern.length();
        int m = str.length();

        // Memoization table initialized with -1 (unvisited state)
        int[][] dp = new int[n][m];

        // Fill with -1 for unvisited
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Call the recursive function
        return f(n - 1, m - 1, pattern, str, dp) ? 1 : 0;
    }

    private boolean f(int i, int j, String pattern, String text, int[][] dp) {
        // Base case: both pattern and text are fully matched
        if (i < 0 && j < 0) return true;

        // Base case: pattern is empty but text is not
        if (i < 0 && j >= 0) return false;

        // Base case: text is empty but pattern still has characters
        if (i >= 0 && j < 0) {
            // The remaining pattern should only contain '*'
            for (int ii = 0; ii <= i; ii++) {
                if (pattern.charAt(ii) != '*') return false;
            }
            return true;
        }

        // Check if we have already computed this state
        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }

        boolean ans = false;

        // Case 1: pattern character matches the text character or is '?'
        if (pattern.charAt(i) == text.charAt(j) || pattern.charAt(i) == '?') {
            ans = f(i - 1, j - 1, pattern, text, dp);
        }

        // Case 2: pattern character is '*'
        else if (pattern.charAt(i) == '*') {
            // Try two possibilities:
            // 1. Treat '*' as an empty sequence -> move in pattern
            // 2. Treat '*' as a non-empty sequence -> move in text
            ans = f(i - 1, j, pattern, text, dp) || f(i, j - 1, pattern, text, dp);
        }

        // Store the result in the memoization table
        dp[i][j] = ans ? 1 : 0;

        return ans;
    }
}



