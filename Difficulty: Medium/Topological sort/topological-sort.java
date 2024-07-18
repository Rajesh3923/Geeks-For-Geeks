//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov; i++)
                list.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = new Solution().topoSort(nov, list);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        
        if(V!=res.length)
        return false;
        
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends


/*Complete the function below*/


class Solution
{
   // using bfs  , we must find the indegree and proceed
   // below this  is DFS
       static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[V];
        Queue<Integer> q = new LinkedList<>();

        // Calculate indegree for each node
        for (int i = 0; i < V; i++) {
            for (int neighbor : adj.get(i)) {
                indegree[neighbor]++;
            }
        }

        // Add nodes with zero indegree to the queue
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int[] res = new int[V];
        int k = 0;

        // Perform topological sorting
        while (!q.isEmpty()) {
            int node = q.poll();
            res[k++] = node; // Add node to the result array

            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);// if cycle exists then indegree
                    //of that node will  ot be 0 and it wont be added to 
                    //the queue so that it cant  be added to the arraylist
                    //,so it arraylist size is not equal to the size of given V
                }
            }
        }

        // Check for cyclic dependencies
        if (k != V) {
            return new int[0]; // Return empty array if there is a cycle
        }

        return res; // Return the topologically sorted array
    }

}












 // using the DFS Approcach
 /*
 
 
 static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int []v=new int[V];
        Arrays.fill(v,0);
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<V;i++){
            if(v[i]==0){
                dfs(i,v,st,adj);
            }
        }
        int []res=new int[V];
        for(int i=0;i<res.length;i++){
            res[i]=st.peek();
            st.pop();
        }
        return res;
    }
    public static void dfs(int node,int []v,Stack<Integer>st,ArrayList<ArrayList<Integer>> adj){
        v[node]=1;
        for(int i:adj.get(node)){
            if(v[i]==0){
                dfs(i,v,st,adj);
            }
        }
        st.push(node);
    }
 */