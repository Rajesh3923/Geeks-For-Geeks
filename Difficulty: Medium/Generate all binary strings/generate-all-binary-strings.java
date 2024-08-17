//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      Solution obj = new Solution();
      List<String> ans = obj.generateBinaryStrings(n);
      for(String s : ans) System.out.print(s+" ");
      System.out.println();
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
  public static List<String> generateBinaryStrings(int n) {
      List<String> result = new ArrayList<>();
        StringBuilder p = new StringBuilder(); // Processed part
        StringBuilder up = new StringBuilder(); // Unprocessed part

        // Initialize the unprocessed part with 'n' zeros (as placeholders)
        for (int i = 0; i < n; i++) {
            up.append('0');
        }

        generateStringsHelper(p, up, result);
        return result;
    }

    private static void generateStringsHelper(StringBuilder p, StringBuilder up, List<String> result) {
        // Base case: If unprocessed part is empty, add the processed string to the result list
        if (up.length() == 0) {
            result.add(p.toString());
            return;
        }

        // Process the next character as '0'
        p.append('0');
        generateStringsHelper(p, new StringBuilder(up.substring(1)), result);
        p.deleteCharAt(p.length() - 1);  // Backtrack

        // Process the next character as '1' only if it does not follow another '1'
        if (p.length() == 0 || p.charAt(p.length() - 1) != '1') {
            p.append('1');
            generateStringsHelper(p, new StringBuilder(up.substring(1)), result);
            p.deleteCharAt(p.length() - 1);  // Backtrack
        }
    
    // code here

  }
}
     
     