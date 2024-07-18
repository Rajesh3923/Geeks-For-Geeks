//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            Solution obj = new Solution();
            long topDownans = obj.topDown(n);
            long bottomUpans = obj.bottomUp(n);
            if (topDownans != bottomUpans)
                System.out.println(-1);
            else
                System.out.println(topDownans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

public class Solution {
    static int mod = 1000000007;

    static long topDown(int n) {
        HashMap<Integer, Long> hm = new HashMap<>();
        return helper(n, hm);
    }

    static long helper(int n, HashMap<Integer, Long> hm) {
        if (n <= 1) {
            return n;
        }
        if (hm.containsKey(n)) {
            return hm.get(n) % mod;
        }
        long val = (helper(n - 1, hm) + helper(n - 2, hm)) % mod;
        hm.put(n, val);
        return val;
    }

    static long bottomUp(int n) {
        if (n <= 1) {
            return n;
        }
        long[] a = new long[n + 1];
        a[0] = 0;
        a[1] = 1;
        for (int i = 2; i <= n; i++) {
            a[i] = (a[i - 1] + a[i - 2]) % mod;
        }
        return a[n] % mod;
    }
}
