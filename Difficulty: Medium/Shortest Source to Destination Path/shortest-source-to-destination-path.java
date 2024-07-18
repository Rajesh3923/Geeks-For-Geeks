//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}
// } Driver Code Ends

//BFS explores nodes level by level. This means that
//when a node is reached for the first time, it is
//reached with the shortest possible distance from the start node.

//** bfs ensures that , it reaches to
//destination in less time (cz less nodes to reach there),then traversing all nodes i.e., longest path
class Pair {
    int d;
    int r;
    int c;

    public Pair(int d, int r, int c) {
        this.d = d;
        this.r = r;
        this.c = c;
    }
}

class Solution {
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        // Return -1 if starting cell is blocked
        if (A[0][0] == 0) return -1;
        if (0 == X && 0 == Y) return 0;

        // Queue for BFS
        Queue<Pair> q = new LinkedList<>();
        int[][] dist = new int[N][M];

        // Initialize distances with infinity
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        // Start BFS from (0, 0)
        q.add(new Pair(0, 0, 0));
        dist[0][0] = 0;

        // Directions for moving up, right, down, left
        int[] drow = {-1, 0, +1, 0};
        int[] dcol = {0, +1, 0, -1};

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int curDist = p.d;
            int r = p.r;
            int c = p.c;

            for (int i = 0; i < 4; i++) {
                int newRow = r + drow[i];
                int newCol = c + dcol[i];

                // Check if the new position is valid
                if (isValid(newRow, newCol, A, N, M)) {
                    // If new distance is shorter, update and add to queue
                    if (dist[newRow][newCol] > curDist + 1) {
                        dist[newRow][newCol] = curDist + 1;
                        q.add(new Pair(curDist + 1, newRow, newCol));
                    }

                    // Return the distance if we reach the destination
                    if (newRow == X && newCol == Y) {
                        return dist[newRow][newCol];
                    }
                }
            }
        }

        // Return -1 if destination is unreachable
        return -1;
    }

    // Helper function to check if a cell is within bounds and is not blocked
    boolean isValid(int r, int c, int[][] A, int N, int M) {
        return r >= 0 && r < N && c >= 0 && c < M && A[r][c] == 1;
    }
}


