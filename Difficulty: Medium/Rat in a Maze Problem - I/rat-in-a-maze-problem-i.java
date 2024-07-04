//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        StringBuilder p = new StringBuilder();
        
        ArrayList<String> al = new ArrayList<>();
        int r = 0;
        int c = 0;
        if (m[0][0] == 0 || m[n - 1][n - 1] == 0) {
            al.add("-1");
            return al;
        }
        helper(r, c, m, p, n, al);
        return al;
    }

    public static void helper(int r, int c, int[][] m, StringBuilder p, int n, ArrayList<String> al) {
        if (r == n - 1 && c == n - 1) {
            al.add(p.toString());
            return;
        }

        // Check and move UP
        if (r > 0 && m[r-1][c] == 1) {
            m[r][c] = 0;
            p.append("U");
            helper(r - 1, c, m, p, n, al);
            p.deleteCharAt(p.length() - 1); // backtrack
            m[r][c] = 1;
        }

        // Check and move RIGHT
        if (c < n - 1 && m[r][c + 1] == 1) {
            m[r][c] = 0;
            p.append("R");
            helper(r, c + 1, m, p, n, al);
            p.deleteCharAt(p.length() - 1); // backtrack
            m[r][c] = 1;
        }

        // Check and move DOWN
        if (r < n - 1 && m[r + 1][c] == 1) {
            m[r][c] = 0;
            p.append("D");
            helper(r + 1, c, m, p, n, al);
            p.deleteCharAt(p.length() - 1); // backtrack
            m[r][c] = 1;
        }

        // Check and move LEFT
        if (c > 0 && m[r][c - 1] == 1) {
            m[r][c] = 0;
            p.append("L");
            helper(r, c - 1, m, p, n, al);
            p.deleteCharAt(p.length() - 1); // backtrack
            m[r][c] = 1;
        }
    }
}

