//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            char[] nuts = new char[n], bolts = new char[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                nuts[i] = (inputLine[i].charAt(0));
            }
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                bolts[i] = (inputLine[i].charAt(0));
            }

            new Solution().matchPairs(n, nuts, bolts);
            for (int i = 0; i < n; i++) {
                System.out.print(nuts[i] + " ");
            }
            System.out.println();
            for (int i = 0; i < n; i++) {
                System.out.print(bolts[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static void matchPairs(int n, char nuts[], char bolts[]) {
        // Use StringBuilder to store nuts and bolts as strings
        StringBuilder nutss = new StringBuilder();
        StringBuilder boltss = new StringBuilder();
        // Convert arrays to StringBuilder
        for (char nut : nuts) {
            nutss.append(nut);
        }
        for (char bolt : bolts) {
            boltss.append(bolt);
        }
        // Special characters to match
        String specialChars = "!#$%&*?@^";
        int nutsIndex = 0;
        int boltsIndex = 0;
        // Match nuts and bolts based on special characters
        for (int i = 0; i < specialChars.length(); i++) {
            char specialChar = specialChars.charAt(i);
            if (nutss.indexOf(Character.toString(specialChar)) >= 0) {
                nuts[nutsIndex++] = specialChar;
            }
        }
        for (int i = 0; i < specialChars.length(); i++) {
            char specialChar = specialChars.charAt(i);
            if (boltss.indexOf(Character.toString(specialChar)) >= 0) {
                bolts[boltsIndex++] = specialChar;
            }
        }

       
    }
}