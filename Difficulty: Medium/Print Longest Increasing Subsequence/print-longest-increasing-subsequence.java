//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.longestIncreasingSubsequence(N, arr);
            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i) + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends



class Solution {
    public ArrayList<Integer> longestIncreasingSubsequence(int n, int[] arr) {
        int[] T = new int[n]; // Array to store the length of LIS ending at each index
        int[] prev = new int[n]; // Array to store the previous index of the LIS

        // Initialize T with 1 as each element is an LIS of length 1 by itself
        for (int i = 0; i < n; i++) {
            T[i] = 1;
            prev[i] = -1; // Initialize previous index as -1 (no previous element)
        }

        // Fill T and prev arrays
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && T[j] + 1 > T[i]) {
                    T[i] = T[j] + 1;
                    prev[i] = j;
                }
            }
        }

        // Find the index of the maximum value in T
        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            if (T[i] > T[maxIndex]) {
                maxIndex = i;
            }
        }

        // Reconstruct the LIS sequence
        ArrayList<Integer> lis = new ArrayList<>();
        for (int i = maxIndex; i >= 0; i = prev[i]) {
            lis.add(arr[i]);
            if (prev[i] == -1) {
                break;
            }
        }

        // The sequence is built in reverse order, so reverse it
        Collections.reverse(lis);
        return lis;
    }
}


