//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String a = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.solve(a));
                }
                
        }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String solve(String a)
     {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<a.length();i++){
            if(isVowel(a.charAt(i))==false){
              if(!map.containsKey(a.charAt(i))){
                    map.put(a.charAt(i),1);
                }else{
                    map.put(a.charAt(i),map.get(a.charAt(i))+1);
                }  
            }
                
        }
        if(map.size()%2==0){
            return "SHE!";
        }
        return "HE!";
    }
    public boolean isVowel(Character ch){
        if(ch=='a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }
        return false;
    }
}