//{ Driver Code Starts
//Initial Template for Java

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
            String s = sc.next ();
            if (new Sol().checkBinary (s))
    		    System.out.println ("VALID");
    		else
    		    System.out.println ("INVALID");
        }
        
    }
}
// Contributed By: Pranay Bansal

// } Driver Code Ends


//User function Template for Java

class Sol
{
    Boolean checkBinary (String s){
        int p = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='0')
                p++;
            else
                break;
        }
        for(int i = p;i<s.length()-1;i++){
            if(s.charAt(i)=='0' && s.charAt(i+1)=='1')
                return false;
        }
        return true;
    }
}
