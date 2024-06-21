//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str = read.readLine().trim();
            String ans = ob.compareFrac(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

   public String compareFrac(String str) {
    // Split the input string into two parts based on comma and space
    String[] fractions = str.split(", ");
    
    // Split the first fraction into numerator and denominator
    String[] fraction1 = fractions[0].split("/");
    double a = Double.parseDouble(fraction1[0]);
    double b = Double.parseDouble(fraction1[1]);
    
    // Split the second fraction into numerator and denominator
    String[] fraction2 = fractions[1].split("/");
    double c = Double.parseDouble(fraction2[0]);
    double d = Double.parseDouble(fraction2[1]);
    
    // Calculate the value of both fractions
    double value1 = a / b;
    double value2 = c / d;
    
    // Compare the two fractions
    if (value1 > value2) {
        return fractions[0]; // Return the first fraction if it's greater
    } else if (value1 < value2) {
        return fractions[1]; // Return the second fraction if it's greater
    } else {
        return "equal"; // Return "equal" if both fractions are the same
    }
}


}
