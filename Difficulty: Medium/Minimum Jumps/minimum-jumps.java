//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String)br.readLine()).split("\\s+");
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(new Solution().minJumps(arr, size));
        }
    }
}

// } Driver Code Ends

class Solution {
    static int minJumps(int[] arr, int n) {
           int count = 0;
        if (n == 0 || n == 1) {
return 0;
 
}
if (arr[0] == 0) {
return -1;
}
int current = 0;
        int maxJump = 0;
        
        for(int i =0;i<n;i++){
        maxJump = Math.max(maxJump, arr[i] +i);
        
        if(i==current){
            count++;
            current = maxJump;
        }
        if(current >= n-1) return count;
        
        }
        
return -1;
        
}}