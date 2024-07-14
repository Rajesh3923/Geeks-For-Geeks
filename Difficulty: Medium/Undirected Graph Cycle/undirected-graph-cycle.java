//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V];
        
        // Iterate through each node to handle disconnected components
        for (int i = 0; i < V; i++) {
            // If the node is not visited, perform DFS to detect a cycle
            if (visited[i] == 0) {
                if (dfsCheckCycle(i, -1, adj, visited)) {
                    return true;// for every 
                }
            }
        }
        // If no cycle is detected in any component, return false
        return false;
    }

    // Helper function to perform DFS and check for cycles
    public static boolean dfsCheckCycle(int node, int parent, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        // Mark the current node as visited
        visited[node] = 1;

        // Traverse all adjacent nodes (neighbors)
        for (int neighbor : adj.get(node)) {
            // If the adjacent node is not visited, recursively call dfsCheckCycle
            if (visited[neighbor] == 0) {
                if (dfsCheckCycle(neighbor, node, adj, visited)) {
                    return true; // it receives the true from else if, if a cycle is found
                }
            }
            // If the adjacent node is visited and not the parent, a cycle is detected
            else if (neighbor != parent) {
                return true;
            }
        }
        // No cycle detected in this path
        return false;
    }

}

// bfs code below 

/**
class Pair{
    int node ;
    int parent;
    public Pair(int node,int parent){
        this.node=node;
        this.parent=parent;
    }
}

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Create a visited array to track visited nodes
        int[] visited = new int[V];
        
        // Iterate through each node to handle disconnected components
        for (int i = 0; i < V; i++) {
            // If the node is not visited, perform BFS to detect a cycle
            if (visited[i] == 0) {
                if (bfsCheckCycle(i, adj, visited)) {
                    return true;
                }
            }
        }
        // If no cycle is detected in any component, return false
        return false;
    }

    // Helper function to perform BFS and check for cycles
    public boolean bfsCheckCycle(int start, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, -1));
        visited[start] = 1;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int node = p.node;
            int parent = p.parent;

            // Traverse all adjacent nodes
            for (int neighbor : adj.get(node)) {
                if (visited[neighbor] == 0) {
                    // If the node is not visited, mark it as visited and add to the queue
                    q.add(new Pair(neighbor, node));
                    visited[neighbor] = 1;
                } else if (neighbor != parent) {
                    // If the node is visited and is not the parent, a cycle is detected
                    return true;
                }
            }
        }
        // No cycle detected in this component
        return false;
    }
    
}
*/


