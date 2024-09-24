//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends

class Solution {
    // Function to find the smallest window in the string s consisting
    // of all the characters of string p.
    public static String smallestWindow(String s, String p) {
        // Base case: If either string is empty
        if (s.length() == 0 || p.length() == 0) return "-1";

        // HashMap to store the frequency of characters in string 'p'
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Variables for tracking the window
        int start = 0, minLength = Integer.MAX_VALUE, windowStart = 0, matchedCount = 0;
        int requiredMatches = p.length();

        // First traversal: Find the first window containing all characters from 'p'
        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            // If the current character is in 'p', decrease its count in the map
            if (map.containsKey(currentChar)) {
                map.put(currentChar, map.get(currentChar) - 1);
                if (map.get(currentChar) >= 0) { // Valid match
                    matchedCount++;
                }
            }

            // Once all characters are matched, proceed to shrink the window
            if (matchedCount == requiredMatches) {
                // Second traversal: Shrink the window until map contains no valid characters
                while (true) {
                    char leftChar = s.charAt(start);

                    // We check if the left character is part of the required characters
                    if (map.containsKey(leftChar)) {
                        if (map.get(leftChar) == 0) { // As soon as count is 0, we know we cannot shrink anymore
                            break;
                        }
                        map.put(leftChar, map.get(leftChar) + 1); // Increase count as we move left
                    }
                    start++;
                }

                // Update the smallest window length if a smaller window is found
                if (end - start + 1 < minLength) {
                    minLength = end - start + 1;
                    windowStart = start;
                }
            }
        }

        // If no valid window is found, return "-1"
        if (minLength == Integer.MAX_VALUE) return "-1";

        // Return the smallest window substring
        return s.substring(windowStart, windowStart + minLength);
    }
}
