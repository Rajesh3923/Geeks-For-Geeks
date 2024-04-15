//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int k;
            k = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.minimizeDifference(n, k, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



 class Solution {
    public static int minimizeDifference(int n, int k, int[] arr) {
        
        int[] maxSuffix = new int[n + 1];
        int[] minSuffix = new int[n + 1];

        
        maxSuffix[n] = Integer.MIN_VALUE;
        minSuffix[n] = Integer.MAX_VALUE;

        
        maxSuffix[n - 1] = arr[n - 1];
        minSuffix[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxSuffix[i] = Math.max(maxSuffix[i + 1], arr[i]);
            minSuffix[i] = Math.min(minSuffix[i + 1], arr[i]);
        }

         
        int maxPrefix = arr[0];
        int minPrefix = arr[0];

       
        int minDiff = maxSuffix[k] - minSuffix[k];

        
        for (int i = 1; i < n; i++) {
             
            if (i + k <= n) {
                 
                int maxi = Math.max(maxSuffix[i + k], maxPrefix);
                int mini = Math.min(minSuffix[i + k], minPrefix);
                 
                minDiff = Math.min(minDiff, maxi - mini);
            }
            
            maxPrefix = Math.max(maxPrefix, arr[i]);
            minPrefix = Math.min(minPrefix, arr[i]);
        }
         
        return minDiff;
    }
}     
