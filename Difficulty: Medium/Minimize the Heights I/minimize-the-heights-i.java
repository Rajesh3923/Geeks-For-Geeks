//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read the number of test cases (t)
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine().trim());
            String input = br.readLine().trim();

            // Split the input line into integers and store them in the array
            String[] tokens = input.split(" ");
            int[] arr = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }

            // Create an instance of the Solution class
            Solution ob = new Solution();

            // Call the getMinDiff method
            int res = ob.getMinDiff(k, arr);

            // Print the result
            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public int getMinDiff(int k, int[] arr) {
        // Edge case: If the array has less than 2 elements, there's no difference
        if (arr.length <= 1) {
            return 0;
        }
        
        // Sort the array to make decision-making easier
        Arrays.sort(arr);
        
        // Initial difference between the maximum and minimum towers
        int diff = arr[arr.length - 1] - arr[0];
        
        // Consider modifying the towers
        for (int i = 1; i < arr.length; i++) {
            // Calculate the new maximum and minimum heights after modification
            int maxHeight = Math.max(arr[i - 1] + k, arr[arr.length - 1] - k);
            int minHeight = Math.min(arr[0] + k, arr[i] - k);
            
            // Update the minimum difference
            diff = Math.min(diff, maxHeight - minHeight);
        }
        
        return diff;
    }
}
