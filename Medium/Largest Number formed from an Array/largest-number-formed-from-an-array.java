//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            String[] arr = br.readLine().trim().split(" ");

            String ans = new Solution().printLargest(n, arr);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends




class Solution {
    String printLargest(int n, String[] arr) {
        // Sort the array based on the custom comparator
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;

                // Compare in descending order to get the largest number
                return order2.compareTo(order1);
            }
        });

        // Concatenate the sorted array elements
        StringBuilder result = new StringBuilder();
        for (String num : arr) {
            result.append(num);
        }

        // Handle the case where the result starts with multiple zeros
        if (result.charAt(0) == '0') {
            return "0";
        }

        return result.toString();
    }
}
