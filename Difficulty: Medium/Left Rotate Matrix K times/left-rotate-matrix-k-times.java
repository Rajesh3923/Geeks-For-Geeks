//{ Driver Code Starts
// Initial Template for java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            int k = Integer.parseInt(S[2]);
            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                String S1[] = read.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    mat[i][j] = Integer.parseInt(S1[j]);
                }
            }
            Solution ob = new Solution();
            int ans[][] = ob.rotateMatrix(k, mat);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


// User function template for java

class Solution {
    public int[][] rotateMatrix(int k, int[][] mat) {
        int rows = mat.length;
        for (int i = 0; i < rows; i++) {
            // Rotate each row by k times
            rotateRow(mat[i], k);
        }
        return mat;
    }

    private void rotateRow(int[] row, int k) {
        int n = row.length;
        k = k % n; // In case k is greater than the length of the row

        // Step 1: Reverse the first n - k elements
        reverse(row, 0, n - 1);
    
        reverse(row, 0, n - k - 1);

        // Step 2: Reverse the last k elements
        reverse(row, n - k, n - 1);

        // Step 3: Reverse the entire row
        
}
    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
