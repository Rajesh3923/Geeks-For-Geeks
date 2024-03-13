//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] mat = new int[n][n];
            String[] S = br.readLine().trim().split(" ");
            int i = 0;
            int j = 0;
            for(int k = 0; k < S.length; k++){
                mat[i][j] = Integer.parseInt(S[k]);
                j++;
                if(j == n){
                    i++;
                    j = 0;
                }
            }
            Solution obj = new Solution();
            int[] ans = obj.matrixDiagonally(mat);
            for(int it = 0; it < ans.length; it++){
                System.out.print(ans[it] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends

class Solution {
    public int[] matrixDiagonally(int[][] mat) {
        int n=mat.length,sum=n+n-2,ind=0;
        int arr[]=new int[n*n];
        for(int k=0;k<=sum;k++){
            for(int j=Math.max(0,k-n+1);;j++){
                if(k-j<0 || k-j>=n || j<0 || j>=n) break;
                if(k%2==0) arr[ind++]=mat[k-j][j];
                else arr[ind++]=mat[j][k-j];
            }
        }
        return arr;
    }
}