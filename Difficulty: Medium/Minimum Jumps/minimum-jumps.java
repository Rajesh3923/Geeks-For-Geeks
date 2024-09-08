//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
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

            System.out.println(new Solution().minJumps(arr));
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static int minJumps(int[] arr) {
        // Edge case: if the array is null or has less than 2 elements, no jumps are needed
        if (arr == null || arr.length < 2) {
            return 0;
        }

        // Initialize pointers for the current window of indices we are considering
        int l = 0;
        int r = 0;
        int jumps = 0;

        // While we haven't reached the last index
        while (r < arr.length - 1) {
            int farthest = 0;

            // Calculate the farthest index we can reach within the current window
            for (int i = l; i <= r; i++) {
                farthest = Math.max(farthest, i + arr[i]);
            }

            // If we can't progress, return -1 (i.e., unreachable last index)
            if (farthest <= r) {
                return -1;
            }

            // Update the window to the next segment
            l = r + 1;
            r = farthest;

            // Increment the number of jumps
            jumps++;
        }

        return jumps;
    }
}
