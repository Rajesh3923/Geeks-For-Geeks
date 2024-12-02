//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s, patt;
            s = sc.next();
            patt = sc.next();

            Solution ob = new Solution();

            ArrayList<Integer> res = ob.search(patt, s);
            if (res.size() == 0)
                System.out.print("[]");
            else {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    private final int PRIME = 101;

    // Method to calculate the hash value of a string
    private double calculateHash(String str) {
        double hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash += str.charAt(i) * Math.pow(PRIME, i);
        }
        return hash;
    }

    // Method to update the hash when sliding the window in the text
    private double updateHash(double prevHash, char oldChar, char newChar, int patternLength) {
        double newHash = (prevHash - oldChar) / PRIME;
        newHash += newChar * Math.pow(PRIME, patternLength - 1);
        return newHash;
    }

    // Main search method
    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> matchIndices = new ArrayList<>(); // List to store 1-based indices
        int patternLength = pat.length();
        int textLength = txt.length();

        // Calculate hash values for the pattern and the first window of text
        double patternHash = calculateHash(pat);
        double textHash = calculateHash(txt.substring(0, patternLength));

        for (int i = 0; i <= textLength - patternLength; i++) {
            // Check if hashes match and verify with actual strings
            if (textHash == patternHash && txt.substring(i, i + patternLength).equals(pat)) {
                matchIndices.add(i); // Add 1-based index to the list
            }

            // Update the hash for the next window
            if (i < textLength - patternLength) {
                textHash = updateHash(textHash, txt.charAt(i), txt.charAt(i + patternLength), patternLength);
            }
        }
        return matchIndices; // Return the list of 1-based match indices
    }
}
