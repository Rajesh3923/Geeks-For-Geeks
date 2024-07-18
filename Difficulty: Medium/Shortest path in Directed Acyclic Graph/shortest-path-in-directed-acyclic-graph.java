//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends

// here we make use of toposort technique , that to reach v , u comes beofre and recahed 
// the idea is to perform the "TOPOSORT", so that reachability for curr node takes place 
class Solution {

    public int[] shortestPath(int N, int M, int[][] edges) {
        // Step 1: Initialize the adjacency list with weights
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        // Step 2: Populate the adjacency list
        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            adj.get(u).add(new int[]{v, w}); // Add edge u -> v with weight w
        }

        // Step 3: Perform topological sorting
        int[] visited = new int[N];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (visited[i] == 0) {
                dfs(i, visited, adj, stack);
            }
        }

        // Step 4: Initialize distances and process nodes in topological order
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0; // Assuming the source node is 0

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (dist[node] != Integer.MAX_VALUE) {
                for (int[] neighbor : adj.get(node)) {
                    int v = neighbor[0];
                    int weight = neighbor[1];
                    if (dist[node] + weight < dist[v]) {
                        dist[v] = dist[node] + weight;
                    }
                }
            }
        }

        // Convert unreachable distances from Integer.MAX_VALUE to -1
        for (int i = 0; i < N; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;
    }

    private void dfs(int node, int[] visited, List<List<int[]>> adj, Stack<Integer> stack) {
        visited[node] = 1;
        for (int[] neighbor : adj.get(node)) {
            int v = neighbor[0];
            if (visited[v] == 0) {
                dfs(v, visited, adj, stack);
            }
        }
        stack.push(node);
    }
	
}