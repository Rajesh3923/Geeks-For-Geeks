//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String input[] = read.readLine().split(" ");
            String a = input[0];
            
            Solution ob = new Solution();
            if(ob.sameFreq(a)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    boolean sameFreq(String s) {
        // code here
        
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(hm.containsKey(ch)){
                hm.put(ch,hm.get(ch)+1);
            }else{
                hm.put(ch,1);
            }
        }
        // System.out.println(hm);
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        for(Map.Entry<Character,Integer> ele : hm.entrySet()){
            int val=ele.getValue();
            if(val>max){
                max=val;
            }
            if(val<min){
                min=val;
            }
        }
        // System.out.println(max);
        // System.out.println(min);
        
        if(max-min>1){ // for 'aaabbc' where a=3,b=2,c=1 more than one operation is required to make freq of all characters same 
            return false;
        }else if(max==min){ // for 'aaabbb' no operation is needed since freq is same for all
            return true;
        }
        else{
            int maxcount=0,onecount=0; 
            /*
            onecount keeps track of characters having frequency only 1
            for example - 'aabbc' if we remove c, then all chars will have same frequency
            
            maxcount keeps track of characters having frequency equal to max. If there are two such characters who 
            have frequency is equal to max, then even if we delete one frequency, 
            there will be one ele whose frequency is not equal to others
            for example - 'xxxxyyyyzz', x=4,y=4,z=3 even if remove one x, then also hm will look like x=3,y=4,z=3
            Here we need to use more than one operation to set same frequency for all characters which is not desired.
            
            */
            
            
            for(Map.Entry<Character,Integer> ele : hm.entrySet()){
                if(ele.getValue()==max){
                    maxcount++;
                }
                if(ele.getValue()==1){
                    onecount++;
                }
            }
        // System.out.println(count);
        // System.out.println(onecount);
            if(onecount==1){ 
                return true;
            }if(maxcount>1){
                return false;
            }else{
                return true;
            }
        }
        
    }
}

