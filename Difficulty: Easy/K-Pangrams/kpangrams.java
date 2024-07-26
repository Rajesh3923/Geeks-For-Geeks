//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());
        while (t-- > 0) {
            String str = sc.nextLine();
            int k = Integer.parseInt(sc.nextLine().trim());
            Solution obj = new Solution();
            if (obj.kPangram(str, k))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
      public boolean kPangram(String str, int k) {
        // If the string length is less than 26, it cannot be a pangram
        int alphabeticCount = 0;
                for (char c : str.toCharArray()) {
                    if (Character.isLetter(c)) {
                        alphabeticCount++;
                    }
                }

        // If the number of alphabetic characters is less than 26, it cannot be a pangram
        if (alphabeticCount < 26) return false;
        // Use a HashSet to track unique characters
        HashSet<Character> uniqueChars = new HashSet<>();

        // Count the number of unique characters
         for (char c : str.toCharArray()) {
            // Consider only alphabet characters
            if (Character.isLetter(c)) {
                uniqueChars.add(Character.toLowerCase(c));
            }
        }

        // If we already have 26 unique characters, it's a pangram
        if (uniqueChars.size() == 26) return true;

        // Calculate how many more characters are needed to reach 26 unique characters
        int missingChars = 26 - uniqueChars.size();

        // Check if the number of allowed replacements is enough to cover the missing characters
        return k >= missingChars;
    }
}