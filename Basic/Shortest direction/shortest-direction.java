//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0)
        {
            String s = in.readLine();
            
            Solution ob = new Solution();
            
            System.out.println(ob.shortestPath(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    String shortestPath (String s)
    {
        int eCount=0;
        int nCount=0;
        int sCount=0;
        int wCount=0;
        for(int i=0;i<s.length();i++){
            char p=s.charAt(i);
            if(p=='E'){
                eCount++;
            }
            else if(p=='N'){
                nCount++;
            }
            else if(p=='S'){
                sCount++;
            }else{
                wCount++;
            }
        }
        if(wCount<=eCount){
            eCount-=wCount;
            wCount=0;
        }
        else{
            wCount-=eCount;
            eCount=0;
        }
        if(nCount<=sCount){
            sCount-=nCount;
            nCount=0;
        }else{
            nCount-=sCount;
            sCount=0;
        }
        StringBuilder ans=new StringBuilder();
        if(eCount>0){
            while(eCount!=0){
                ans.append('E');
                eCount--;
            }
        }
        if(nCount>0){
            while(nCount!=0){
                ans.append('N');
                nCount--;
            }
        }
        if(sCount>0){
            while(sCount!=0){
                ans.append('S');
                sCount--;
            }
        }
        if(wCount>0){
            while(wCount!=0){
                ans.append('W');
                wCount--;
            }
        }
        return ans.toString();
    }
}