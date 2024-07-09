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

            out.println(new Solution().threeSumClosest(arr, key));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int threeSumClosest(int[] array, int target) {
           Arrays.sort(array);
        int closestSum = Integer.MAX_VALUE;

        // Iterate through the array
        for (int i = 0; i < array.length - 2; i++) {
            int left = i + 1;
            int right = array.length - 1;

            while (left < right) {
                int sum = array[i] + array[left] + array[right];

                // If the current sum is closer to the target, update the closestSum
                if (Math.abs(target - sum) < Math.abs(target - closestSum) ||
                    (Math.abs(target - sum) == Math.abs(target - closestSum) && sum > closestSum)) {
                    closestSum = sum;
                }

                // Move the pointers based on the comparison of sum and target
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    // If the sum is exactly equal to the target, return the sum
                    return sum;
                }
            }
        }
        return closestSum;
    }
}
