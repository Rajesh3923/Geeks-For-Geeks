//{ Driver Code Starts


import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            List<List<int[]>> list = new ArrayList<>();
            for (int i = 0; i < V; i++) list.add(new ArrayList<>());
            for (int i = 0; i < E; i++) {
                s = br.readLine().trim().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                list.get(a).add(new int[] {b, c});
                list.get(b).add(new int[] {a, c});
            }
            ot.println(new Solution().spanningTree(V, E, list));
        }
        ot.close();
    }
}
// } Driver Code Ends



class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        int[] size = new int[V];
        int[] parent = new int[V];
        
        for (int i = 0; i < V; i++) {
            size[i] = 1;
            parent[i] = i;
        }
        
        // PriorityQueue with custom comparator to sort edges by weight
        PriorityQueue<Edge> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        
        for (int i = 0; i < V; i++) {
            for (int[] edge : adj.get(i)) {
                int srcNode = i;
                int destNode = edge[0];
                int weight = edge[1];
                
                pq.add(new Edge(srcNode, destNode, weight));
            }
        }
        
        int mst = 0;
        
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int node = edge.src;
            int destination = edge.dest;
            int wt = edge.weight;
            
            if (findParent(parent, node) != findParent(parent, destination)) {
                mst += wt;
                unionBySize(parent, size, node, destination);
            }
        }
        
        return mst;
    }
    
    static int findParent(int[] parent, int node) {
        if (parent[node] == node) {
            return node;
        }
        
        parent[node] = findParent(parent, parent[node]);
        return parent[node];
    }
    
    static void unionBySize(int[] parent, int[] size, int u, int v) {
        int parentU = findParent(parent, u);
        int parentV = findParent(parent, v);
        
        if (parentU == parentV) {
            return; // belongs to same component or parent
        } else if (size[parentU] < size[parentV]) {
            parent[parentU] = parentV;
            size[parentV] += size[parentU];
        } else {
            parent[parentV] = parentU;
            size[parentU] += size[parentV];
        }
    }
    
    static class Edge {
        int src, dest, weight;
        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
}


// using the Prims Algo


/*
class Pair{
    int w;
    int node;
    // int parent;
    public Pair(int w,int node){
        this.w=w;
        this.node=node;
        // this.parent=parent;
    }
}
//** if it's visited , then its visited with lowest cost , dont dont enter
class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
       PriorityQueue<Pair>pq=new PriorityQueue<>((x,y)->x.w-y.w);
       int []v=new int[V];
       Arrays.fill(v,0);
       pq.add(new Pair(0,0));
       int sum=0;
       while(!pq.isEmpty()){
           Pair p=pq.poll();
           int w=p.w;
           int node=p.node;
        //   int parent=p.parent;
           if(v[node]==0){
               v[node]=1;
               sum+=w;
               for(int []arr:adj.get(node)){
                   pq.add(new Pair(arr[1],arr[0]));
                   
                   
               }
           }
           
       }return sum;
    }*/