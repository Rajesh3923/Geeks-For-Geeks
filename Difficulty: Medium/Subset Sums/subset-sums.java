//{ Driver Code Starts

// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                arr.add(sc.nextInt());
            }
            Solution ob = new Solution();

            ArrayList<Integer> ans = ob.subsetSums(arr, N);
            Collections.sort(ans);
            for (int sum : ans) {
                System.out.print(sum + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java//User function Template for Java
class Solution {
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
         ArrayList<Integer>al=new ArrayList<>(Arrays.asList(0));
         ArrayList<ArrayList<Integer>> outer = new ArrayList<>();
         outer.add(new ArrayList<>(Arrays.asList(0)));
        for (Integer a : arr) {
            int currentSize = al.size();
            
            // Iterate through the current sums and add the new element to each sum
            for (int i = 0; i < currentSize; i++) {
                al.add(al.get(i) + a);
            }
        }
        return al;
         
        
    }
}