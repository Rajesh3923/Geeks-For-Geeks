//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i = 0;i<n;i++)
                {
                    int x = sc.nextInt();
                    arr.add(x);
                }
            int m = sc.nextInt();
            
            Solution ob = new Solution();
            
    		System.out.println(ob.findMinDiff(arr,n,m));
        }
        
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        // your code here
           if (m > a.size()) {
            return 0;
        }
        Collections.sort(a);
        long ans = Integer.MAX_VALUE;


        int j = m-1;
        int i = 0;


        while (j < a.size()) {
            long diff = a.get(j) - a.get(i);
            if (diff < ans) {
                ans = diff;
            }
            j++;
            i++;
        }
        
        return ans;

        
    }
}