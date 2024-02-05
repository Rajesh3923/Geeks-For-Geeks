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
        PrintWriter out=new PrintWriter(System.out);
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int[] a = IntArray.input(br, 3);
            
            
            int[] S1 = IntArray.input(br, a[0]);
            
            
            int[] S2 = IntArray.input(br, a[1]);
            
            
            int[] S3 = IntArray.input(br, a[2]);
            
            Solution obj = new Solution();
            int res = obj.maxEqualSum(a[0],a[1],a[2], S1, S2, S3);
            
            out.println(res);
            
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public static int maxEqualSum(int N1, int N2, int N3, int[] S1, int[] S2, int[] S3) {
        int sum1 = 0, sum2 = 0, sum3 = 0;

        for (int i = 0; i < N1; i++)
            sum1 += S1[i];

        for (int i = 0; i < N2; i++)
            sum2 += S2[i];

        for (int i = 0; i < N3; i++)
            sum3 += S3[i];

        int top1 = 0, top2 = 0, top3 = 0;
        int ans = 0;

        while (true) {
            if (top1 == N1 || top2 == N2 || top3 == N3)
                return 0;

            if (sum1 == sum2 && sum2 == sum3)
                return sum1;

            if (sum1 >= sum2 && sum1 >= sum3)
                sum1 -= S1[top1++];
            else if (sum2 >= sum3 && sum2 >= sum1)
                sum2 -= S2[top2++];
            else if (sum3 >= sum2 && sum3 >= sum1)
                sum3 -= S3[top3++];
        }
    }
}
        
