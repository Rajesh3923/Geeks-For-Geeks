//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class gfg {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) mat[i][j] = sc.nextInt();
            }

            int x = sc.nextInt();

            if (new Solution().matSearch(mat, x))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Solution {
    public static boolean matSearch(int mat[][], int x) {
        int row = 0; 
        int col = mat[0].length - 1; // Start at the top-right corner
        
        while (row < mat.length && col >= 0) {
            if (mat[row][col] == x) {
                return true; // Found the element
            } else if (x < mat[row][col]) {
                col--; // Move left
            } else {
                row++; 
            }
        }
        return false; // Element not found
    }
}
