//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().circularSubarraySum(arr));
            // System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Solution {
    public int circularSubarraySum(int arr[]) {
        int n = arr.length;

        // Step 1: Find the maximum subarray sum using Kadane's Algorithm
        int maxKadane = kadane(arr);

        // Step 2: Find the total sum of the array
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        // Step 3: Invert the array elements and apply Kadane's Algorithm to find the minimum subarray sum
        for (int i = 0; i < n; i++) {
            arr[i] = -arr[i];
        }
        int minSubarraySum = kadane(arr);

        // Step 4: Restore the array
        for (int i = 0; i < n; i++) {
            arr[i] = -arr[i];
        }

        // Step 5: Calculate circular subarray sum
        int maxCircular = totalSum + minSubarraySum;

        // Step 6: Handle edge case for all negative numbers
        if (maxCircular == 0) { // This happens when all elements are negative
            return maxKadane;
        }

        // Step 7: Return the maximum of non-circular and circular sums
        return Math.max(maxKadane, maxCircular);
    }

    // Helper function: Kadane's Algorithm
    private int kadane(int[] arr) {
        int maxSum = Integer.MIN_VALUE, currentSum = 0;
        for (int num : arr) {
            currentSum += num;
            maxSum = Math.max(maxSum, currentSum);
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }
}

