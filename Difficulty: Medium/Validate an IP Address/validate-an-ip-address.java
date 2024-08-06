//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

public class validip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();

            if (obj.isValid(s))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

   public boolean isValid(String str) {
    // Split the string by the dot (.)
    String[] parts = str.split("\\.");
    
    // IPv4 address must have exactly four parts
    if (parts.length != 4) {
        return false;
    }
    
    for (String part : parts) {
        // Check if part is a number
        if (!part.matches("\\d+")) {
            return false;
        }
        
        // Convert part to integer
        int num;
        try {
            num = Integer.parseInt(part);
        } catch (NumberFormatException e) {
            return false;
        }
        
        // Check if the number is in the range 0-255
        if (num < 0 || num > 255) {
            return false;
        }
        
        // Check for leading zeros (except for the number "0")
        if (part.length() > 1 && part.startsWith("0")) {
            return false;
        }
    }
    
    return true;
}

}