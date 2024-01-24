//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 


// } Driver Code Ends
//User function Template for Java

class Solution 
{ 
    static int catchThieves(char[] arr, int n, int k) {
        ArrayList<Integer> policemen = new ArrayList<>();
        ArrayList<Integer> thieves = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (arr[i] == 'P') {
                policemen.add(i);
            } else if (arr[i] == 'T') {
                thieves.add(i);
            }
        }

        int i = 0, j = 0, res = 0;

        while (i < policemen.size() && j < thieves.size()) {
            if (Math.abs(thieves.get(j) - policemen.get(i)) <= k) {
                res++;
                i++;
                j++;
            } else if (policemen.get(i) < thieves.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return res;
    }

} 



//{ Driver Code Starts.
class GFG{
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
			char arr[] = new char[n];
			for(int i=0; i<n; i++)
         		arr[i] = sc.next().charAt(0);

			Solution ob = new Solution();
            System.out.println(ob.catchThieves(arr, n, k));
            t--;
        }
    }
}       
// } Driver Code Ends