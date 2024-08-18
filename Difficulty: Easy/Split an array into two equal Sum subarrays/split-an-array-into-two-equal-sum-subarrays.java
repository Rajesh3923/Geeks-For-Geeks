//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] s = br.readLine().trim().split(" ");

            int[] arr = new int[s.length];
            for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(s[i]);

            Solution obj = new Solution();
            boolean res = obj.canSplit(arr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public boolean canSplit(int arr[]) {
        if (arr.length==1)return false;
        
        int s=0;
        int e=arr.length-1;
        int sprefix=arr[0];
        int eprefix=arr[e];
        while(s<e){
           
            if(sprefix<eprefix){
                s++;
                sprefix+=arr[s];
            }
            else if(sprefix==eprefix&& e-s==1){
                return true;
            }
            else{
                e--;
                eprefix+=arr[e];
            }
           
           
            
        }return false;
    }
}