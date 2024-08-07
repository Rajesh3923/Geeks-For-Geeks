//{ Driver Code Starts
//Initial template for JAVA

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
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j]  =Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            obj.shortest_distance(matrix);
            for(int i = 0; i < n; i++){
                for(int j  = 0; j < n; j++){
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


//User function template for JAVA

class Solution
{
    public void shortest_distance(int[][] matrix)
    {   int r=matrix.length;
        int c=matrix[0].length;
         for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j]==-1){
                    matrix[i][j]= 9999;
                }
                if(i==j)matrix[i][j]=0;
            }
         }
         // here k is the no of nodes , so matrix is multiplied with that
         // no of times ,
        for(int k=0;k<r;k++){
            for(int i=0;i<c;i++){
                for(int j=0;j<r;j++){
                    matrix[i][j]=Math.min(matrix[i][j],(matrix[i][k]+matrix[k][j]));
                }
            }
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j]==9999){
                    matrix[i][j]= -1;
                }
                
            }
         }
    }
}