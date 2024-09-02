//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends



class Solution {
    // Function to return the minimum cost to reach the bottom
    // right cell from the top left cell.
    public int minimumCostPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        // PriorityQueue to store {cost, row, col}, ordered by cost.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        // 2D array to store the minimum cost to reach each cell
        int[][] minCost = new int[n][m];
        for (int[] row : minCost) {
            java.util.Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        // Directions for moving up, down, left, right
        int[] drow = {-1, 1, 0, 0};
        int[] dcol = {0, 0, -1, 1};
        
        // Start from the top-left corner
        pq.add(new int[]{grid[0][0], 0, 0});
        minCost[0][0] = grid[0][0];
        
        // Process the priority queue
        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            int cost = arr[0];  // current minimum cost to reach this cell
            int r = arr[1];     // current row
            int c = arr[2];     // current column
            
            // If we reached the bottom-right corner, return the cost
            if (r == n - 1 && c == m - 1) {
                return cost;
            }
            
            // Explore the 4 possible directions
            for (int i = 0; i < 4; i++) {
                int newRow = r + drow[i];
                int newCol = c + dcol[i];
                
                // If the new position is within bounds
                if (isValid(newRow, newCol, n, m)) {
                    int newCost = cost + grid[newRow][newCol];
                    
                    // If the new cost is lower than the previously recorded cost, update and add to queue
                    if (newCost < minCost[newRow][newCol]) {
                        minCost[newRow][newCol] = newCost;
                        pq.add(new int[]{newCost, newRow, newCol});
                    }
                }
            }
        }
        
        // If the bottom-right cell cannot be reached, return -1
        return -1;
    }
    
    // Helper function to check if the position is valid
    public static boolean isValid(int r, int c, int n, int m) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}













