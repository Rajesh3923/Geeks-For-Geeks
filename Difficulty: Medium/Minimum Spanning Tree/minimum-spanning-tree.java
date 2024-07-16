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


// User function Template for Java
class Pair{
    int w;
    int node;
    int parent;
    public Pair(int w,int node,int parent){
        this.w=w;
        this.node=node;
        this.parent=parent;
    }
}
class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
       PriorityQueue<Pair>pq=new PriorityQueue<>((x,y)->x.w-y.w);
       int []v=new int[V];
       Arrays.fill(v,0);
       pq.add(new Pair(0,0,-1));
       int sum=0;
       while(!pq.isEmpty()){
           Pair p=pq.poll();
           int w=p.w;
           int node=p.node;
           int parent=p.parent;
           if(v[node]==0){
               v[node]=1;
               sum+=w;
               for(int []arr:adj.get(node)){
                   pq.add(new Pair(arr[1],arr[0],node));
                   
                   
               }
           }
           
       }return sum;
    }
}