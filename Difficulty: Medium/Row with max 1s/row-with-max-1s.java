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
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");
        
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new Solution().rowWithMax1s(arr, n, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int rowWithMax1s(int arr[][], int n, int m) {
    int maxOnes = 0;
    int rowWithMaxOnes = -1;

    // Traverse each row in the 2D array
    for (int i = 0; i < n; i++) {
        // Use binary search to find the number of 1's in the current row
        int countOnes =lowerBound(arr[i], m, 1);
        
        // Update maxOnes and rowWithMaxOnes if current row has more 1's
        if (countOnes > maxOnes) {
            maxOnes = countOnes;
            rowWithMaxOnes = i;
        }
    }

    return rowWithMaxOnes;
}

// Binary search function to find the lower bound of x in sorted array arr
int lowerBound(int[] arr, int n, int x) {
    int low = 0, high = n - 1;
    int ans = n;

    while (low <= high) {
        int mid = (low + high) / 2;
        // Maybe an answer
        if (arr[mid] >= x) {
            ans = mid;
            // Look for smaller index on the left
            high = mid - 1;
        } else {
            low = mid + 1; // Look on the right
        }
    }
    return ans;
}

}