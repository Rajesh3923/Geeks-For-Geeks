//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class DisjointSet {
    int[] parent, size;

    public DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]);  // Path compression
        }
        return parent[node];
    }

    public void unionBySize(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);

        if (rootU != rootV) {
            if (size[rootU] < size[rootV]) {
                parent[rootU] = rootV;
                size[rootV] += size[rootU];
            } else {
                parent[rootV] = rootU;
                size[rootU] += size[rootV];
            }
        }
    }
}

class Solution {
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        int n = rows * cols;
        DisjointSet ds = new DisjointSet(n);
        int[][] vis = new int[rows][cols];
        int[] dirX = {-1, 1, 0, 0};
        int[] dirY = {0, 0, -1, 1};
        int count = 0;

        List<Integer> ans = new ArrayList<>();

        for (int[] op : operators) {
            int row = op[0];
            int col = op[1];

            if (vis[row][col] == 1) {
                ans.add(count);
                continue;
            }

            vis[row][col] = 1;
            count++;

            int currentCell = row * cols + col;

            for (int i = 0; i < 4; i++) {
                int newRow = row + dirX[i];
                int newCol = col + dirY[i];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && vis[newRow][newCol] == 1) {
                    int adjacentCell = newRow * cols + newCol;
                    if (ds.find(currentCell) != ds.find(adjacentCell)) {// checking for ultimate boss , if down side is 1 
                    // and left side is 1 , by connecting to downside , u r even connected 
                    // to left side ,so this step gives same parent of down and left
                        count--;
                        ds.unionBySize(currentCell, adjacentCell);
                    }
                }
            }
            ans.add(count);
        }
        return ans;
    }
}




//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int  k= sc.nextInt();
            int[][] a = new int[k][2];
            for(int i=0;i<k;i++){
            
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            List<Integer> ans = obj.numOfIslands(n,m,a);
           
            for(int i:ans){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends