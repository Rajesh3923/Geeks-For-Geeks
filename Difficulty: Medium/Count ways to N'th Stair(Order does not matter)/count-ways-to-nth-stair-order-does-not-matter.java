//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            long ans = ob.nthStair(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class Solution {
    Integer dp[];
    public int dfs(int n,int index)
    {
        if(index>n) return 0;
        if(index==n) return 1;
        if(dp[index]!=null)return dp[index];
        return dp[index]=1+Math.min(dfs(n,index+1),dfs(n,index+2));
    }
    public int nthStair(int n) {
        // Code here
        dp=new Integer[n+1];
        return dfs(n,0);
    }
}