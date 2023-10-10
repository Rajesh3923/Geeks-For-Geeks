//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            
            
            // input n array elements
            String S= read.readLine();
           

            Solution ob = new Solution();
           
            System.out.println(ob.isSquare(S));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int isSquare(String S)
{
     //code here
        int sum=0;
        for(int i=0;i<S.length();i++){
            Character ch=S.charAt(i);
            int asciiValue=(int)ch;
            sum+=asciiValue;
        }
         int sqrt = (int) Math.sqrt(sum);
        if(sqrt * sqrt == sum){
            return 1;
        }
        return 0;
    }
}