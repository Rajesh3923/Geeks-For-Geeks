//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int key = Integer.parseInt(in.readLine().trim());

            out.println(new Solution().search(arr, key));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int search(int[] arr, int key) {
    int l = 0;
    int h = arr.length - 1;
    while (l <= h) {
        int m = (l + h) / 2;
        if (arr[m] == key) return m;
        
        // Check if the left side is sorted
        if (arr[l] <= arr[m]) {
            if (key >= arr[l] && key < arr[m]) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        // Otherwise, the right side must be sorted
        else {
            if (key > arr[m] && key <= arr[h]) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
    }
    return -1;
}

}