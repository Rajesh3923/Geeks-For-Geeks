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
        
        for(int i = 0; i < V; i++) {
            size[i] = 1;
            parent[i] = i;
        }
        
        List<Edge> edges = new ArrayList<Edge>();
        
        for(int i = 0; i < V; i++) {
            int ajdNodeListSize = adj.get(i).size();
            for(int j = 0; j < ajdNodeListSize; j++) {
                int srcNode = i;
                int destNode = adj.get(i).get(j)[0];
                int weight = adj.get(i).get(j)[1];
                
                edges.add(new Edge(srcNode, destNode, weight));
            }
        }
        
        Collections.sort(edges);
        int mst = 0;
        int edgeSize = edges.size();
        
        for(int i = 0; i < edgeSize; i++) {
            int node = edges.get(i).src;
            int destination = edges.get(i).dest;
            int wt = edges.get(i).weight;
            
            if(findParent(parent, node) != findParent(parent, destination)) {
                mst += wt;
                unionBySize(parent, size, node, destination);
            }
        }
        
        return mst;
        
    }
    
    static int findParent(int[] parent, int node) {
        if(parent[node] == node) {
            return node;
        }
        
        parent[node] = findParent(parent, parent[node]);
        return parent[node];
    }
    
    static void unionBySize(int[] parent, int[] size, int u, int v) {
        int parentU = findParent(parent, u);
        int parentV = findParent(parent, v);
        
        if(parentU == parentV) {
            return; // belongs to same component or parent
        } else if(size[parentU] < size[parentV]) {
            parent[parentU] = parentV;
            size[parentV] += size[parentU];
        } else  {
            parent[parentV] = parentU;
            size[parentU] += size[parentV];
        }
    }
}

class Edge implements Comparable<Edge> {
    int src, dest, weight;
    Edge(int src, int dest, int wt) {
        this.src = src;
        this.dest = dest;
        this.weight = wt;
    }
    
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
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