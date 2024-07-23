//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    public int[] findTwoElement(int arr[], int n) {
        HashSet<Integer> hs = new HashSet<>();
        int repeating = 0;
        long sum = 0;
        
        // Find the repeating number and calculate the sum of elements
        for (int i : arr) {
            sum += i;
            if (hs.contains(i)) {
                repeating = i;
            }
            hs.add(i);
        }
        
        // Calculate the expected sum of the first n natural numbers
        long expectedSum = (long) n * (n + 1) / 2;
        
        // Calculate the missing number using the difference between expected and actual sums
        long missing = expectedSum - (sum - repeating);
        
        return new int[] { repeating, (int) missing };
    }
}