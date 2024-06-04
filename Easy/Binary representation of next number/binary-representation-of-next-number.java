//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.binaryNextNumber(s));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String binaryNextNumber(String s) {
    char carry = '1'; 

    StringBuilder ans = new StringBuilder();

    for (int i = s.length() - 1; i >= 0; i--) {
        if (carry == '1') {
            if (s.charAt(i) == '0') {
                ans.append('1');
                carry = '0';
            } else {
                ans.append('0');
            }
        } else {
            ans.append(s.charAt(i));
        }
    }

    if (carry == '1') {
        ans.append('1'); 
    }

    while (ans.length() > 1 && ans.charAt(ans.length() - 1) == '0') {
        ans.deleteCharAt(ans.length() - 1);
    }

    return ans.reverse().toString();
}

}

