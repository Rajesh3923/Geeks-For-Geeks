//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int n = inputLine.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxProduct(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    int maxProduct(int[] arr) {
        if(arr.length==1)return arr[0];
        int left=1;
        int right=1;
        int maxl=0;
        int maxr=0;
        for(int i=0;i<arr.length;i++){
            left*=arr[i];
            maxl=Math.max(maxl,left);
            if(left==0)left=1;
        }
        for(int i=arr.length-1;i>=0;i--){
            right*=arr[i];
            maxr=Math.max(maxr,right);
            if(right==0)right=1;
        }
        return Math.max(maxl,maxr);
        
    }
}