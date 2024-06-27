//{ Driver Code Starts
import java.util.*;

class Check_IsToepliz {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int arr[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) arr[i][j] = sc.nextInt();
            }

            GfG g = new GfG();
            boolean b = g.isToepliz(arr);

            if (b == true)
                System.out.println("true");
            else
                System.out.println("false");

            T--;
        }
    }
}
// } Driver Code Ends


class GfG {
    /*You are required to complete this method*/
  boolean isToepliz(int mat[][]) {
    int r = mat.length;      // Number of rows
    int c = mat[0].length;   // Number of columns
    
    // No need to check for square matrix, Toeplitz can be rectangular
    
    // Check each diagonal starting from the first row
    for (int col = 0; col < c; col++) {
        // Get the first element of the diagonal
        int val = mat[0][col];
        // Check the rest of the diagonal
        for (int i = 1; i < r && col + i < c; i++) {
            if (mat[i][col + i] != val) {
                return false;
            }
        }
    }
    
    // Check each diagonal starting from the first column
    for (int row = 1; row < r; row++) {
        // Get the first element of the diagonal
        int val = mat[row][0];
        // Check the rest of the diagonal
        for (int i = 1; i < c && row + i < r; i++) {
            if (mat[row + i][i] != val) {
                return false;
            }
        }
    }
    
    return true; // If all diagonals are constant, the matrix is Toeplitz
}

}