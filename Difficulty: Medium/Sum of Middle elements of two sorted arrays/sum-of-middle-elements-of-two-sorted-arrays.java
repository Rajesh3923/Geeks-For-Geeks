//{ Driver Code Starts
// Initial Template for Java

import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public int SumofMiddleElements(int[] arr1, int[] arr2) {
        int l = 0;
        int r = 0;
        int c = 0;
        int ele1 = 0, ele2 = 0;
        int eleOdd = 0;
        boolean even;

        int n1 = arr1.length;
        int n2 = arr2.length;
        int totalLength = n1 + n2;

        int m1, m2;
        if (totalLength % 2 == 0) {
            m1 = totalLength / 2 - 1;
            m2 = totalLength / 2;
            even = true;
        } else {
            m1 = m2 = totalLength / 2;
            even = false;
        }

        while (l < n1 || r < n2) {
            int currentElement;

            if (l < n1 && (r >= n2 || arr1[l] <= arr2[r])) {
                currentElement = arr1[l];
                l++;
            } else {
                currentElement = arr2[r];
                r++;
            }

            if (c == m1) {
                ele1 = currentElement;
            }
            if (c == m2) {
                ele2 = currentElement;
            }
            c++;
        }

        if (even) {
            return ele1 + ele2;
        } else {
            return ele2;
        }
    }
}




//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline
        while (t-- > 0) {
            String[] input1 = sc.nextLine().split(" ");
            int[] arr = new int[input1.length];
            for (int i = 0; i < input1.length; i++) {
                arr[i] = Integer.parseInt(input1[i]);
            }

            String[] input2 = sc.nextLine().split(" ");
            int[] brr = new int[input2.length];
            for (int i = 0; i < input2.length; i++) {
                brr[i] = Integer.parseInt(input2[i]);
            }

            Solution ob = new Solution();
            int res = ob.SumofMiddleElements(arr, brr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends