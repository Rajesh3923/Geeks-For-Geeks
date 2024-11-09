//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String arr[] = br.readLine().split(" ");
            int a[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                a[i] = Integer.parseInt(arr[i]);
            }
            Solution obj = new Solution();
            int f = 0;
            String A = obj.minSum(a);
            System.out.println(A);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
     String minSum(int[] arr) {
        int[]freq = new int[10];
        for(int ele:arr)freq[ele]++; /* count freq of each element */
        for(int a=0,k=9;k>=0;k--)while(freq[k]-->0)arr[a++] = k; /* modified original array which sorted in descending order*/
        int n = arr.length, i=0, j=1, carry=0;
        StringBuilder sb = new StringBuilder();
        while(j<n){
            int sum = arr[i]+arr[j]+carry;
            carry = sum/10;
            sb.append(sum%10);
            i+=2;j+=2;
        }
        if(i<n){
            int sum = arr[i]+carry;
            carry = sum/10;
            sb.append(sum%10);
        }
        if(carry>0)sb.append(carry);
        for(i=sb.length()-1;i>=0;i--)if(sb.charAt(i)!='0')break;
        String ans = sb.substring(0,i+1);
        return new StringBuilder(ans).reverse().toString(); 
    }
}


// class Solution {
//     String minSum(int[] arr) {
//         Arrays.sort(arr);

//         if (arr[0] != 0) {
//             int first = 0;
//             int second = 1;
//             java.math.BigInteger f = find(arr, first);
//             java.math.BigInteger s = find(arr, second);
//             return f.add(s).toString();
//         } else {
//             int first = 1;
//             while (arr[first] == 0) {
//                 first++;
//             }
//             int second = first + 1;
//             java.math.BigInteger f = find(arr, first);
//             java.math.BigInteger s = find(arr, second);
//             return f.add(s).toString();
//         }
//     }

//     // Modified to return BigInteger for handling large values
//     public static java.math.BigInteger find(int[] arr, int start) {
//         java.math.BigInteger sum = java.math.BigInteger.ZERO;
//         java.math.BigInteger ten = java.math.BigInteger.TEN;

//         while (start < arr.length) {
//             sum = sum.multiply(ten).add(java.math.BigInteger.valueOf(arr[start]));
//             start += 2;
//         }

//         return sum;
//     }
// }


