//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public List<String> AllPossibleStrings(String s)
    {
        // Code here
        List<String> list = new ArrayList<>();
        list.add("");
        for (char ch : s.toCharArray()) {
            int n = list.size();
            for (int i = 0; i < n; i++) {
                String str = list.get(i);
                StringBuilder sb = new StringBuilder(str);
                sb.append(ch);
                list.add(sb.toString());
            }
        }
        list.remove(0);
        Collections.sort(list);
        return list;
    }
}