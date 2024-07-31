//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String longestCommonPrefix(String arr[]) {
        int min=Integer.MAX_VALUE;
        if(arr.length==1){
            return arr[0];
        }
        for(int i=0;i<arr.length;i++){
            int len=arr[i].length();
            min=Math.min(len,min);
        }
        StringBuilder str=new StringBuilder();
        for(int i=0;i<min;i++){
            char c=arr[0].charAt(i);
            for(int j=0;j<arr.length;j++){
                if(arr[j].charAt(i)!=c){
                    return str.toString().length()!=0?str.toString():String.valueOf(-1);
                }
                
            }
            str.append(String.valueOf(c));
        }
        return String.valueOf(-1);
    }
}