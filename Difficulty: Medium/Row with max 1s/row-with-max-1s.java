//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new Solution().rowWithMax1s(arr);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int rowWithMax1s(int arr[][]) {
        int max=-1;
        int res=-1;
        int maxx=Integer.MIN_VALUE;
       for(int i=0;i<arr.length;i++){
           max=find(arr[i]);
           if(max>maxx& max!=0){
               maxx=max;
               res=i;
           }
       }
       return res;
       
    }
    public static int find(int[]a){
        int l=0;
        int inx=-1;
        int h=a.length-1;
        while(l<=h){
            int m=(l+(h-l)/2);
            if(a[m]==0){
                l=m+1;
            }
            else{
                h=m-1;
                inx=m;
                
            }
        }return inx != -1 ? a.length - inx : 0;
    }
}
