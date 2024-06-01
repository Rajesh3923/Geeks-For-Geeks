//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            String res = obj.oddEven(s);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static String oddEven(String s) {
        // code here
        HashMap<Character,Integer>hm=new HashMap<>();
        int count=0;
        for(int i=0;i<s.length();i++){
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),1)+1);
            
        }
        for(char c:hm.keySet()){
            int val=c-'a';
            int freq=hm.get(c);
            if(val%2==freq%2) count+=1;
               
            
        }
        return count%2==0?"EVEN":"ODD";
        
    }
}
