//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
// import java.util.*;

class Pair {
    int step;
    int node;

    public Pair(int step, int node) {
        this.step = step;
        this.node = node;
    }
}

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        // If start is already the end, return 0
        if (start == end) return 0;

        // Use a modulo to keep the numbers within a manageable range
        int MOD = 100000;

        // Initialize the distance array with a high value
        int[] dist = new int[MOD];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Queue for BFS
        Queue<Pair> q = new LinkedList<>();
        dist[start] = 0; // Distance to start node is 0
        q.add(new Pair(0, start));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int steps = p.step;
            int node = p.node;

            // Check all possible multiplications
            for (int i : arr) {
                int newNode = (i * node) % MOD;

                // If we find a shorter path to newNode, update the distance and enqueue it
                if (dist[newNode] > steps + 1) {
                    dist[newNode] = steps + 1;
                    q.add(new Pair(steps + 1, newNode));

                    // If we reach the end node, return the steps
                    if (newNode == end) {
                        return steps+1;
                    }
                }
            }
        }

        // If we exit the loop without having found the end, return -1
        return -1;
    }

   

}

