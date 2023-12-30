//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            
            for(int i = 0; i < n; i++)
                arr[i] = sc.next();
            
            Solution obj = new Solution();    
            String result[] = obj.winner(arr, n);
            System.out.println(result[0] + " " + result[1]);
            
           
        }
        
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to return the name of candidate that received maximum votes.
    public static String[] winner(String arr[], int n)
    {
       HashMap<String,Integer>hm=new HashMap<>();
       for(String s:arr){
           hm.put(s,hm.getOrDefault(s,0)+1);
       }
       int max=Collections.max(hm.values());
       List<String>li=new ArrayList<>();
       
       for(String s:hm.keySet()){
                if(hm.get(s)==max){
                li.add(s);
                }
                
           
       }
       Collections.sort(li);
       String ss=li.get(0);
       return new String []{ss,String.valueOf(max)};
           
    }
}

