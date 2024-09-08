//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> a = new ArrayList<>();

            for (String s : inputArray) {
                a.add(Integer.parseInt(s));
            }

            Solution ob = new Solution();
            ob.sort012(a);

            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(ArrayList<Integer> arr) {
       int z=0;
       int o=0;
       int t=0;
       for(int i=0;i<arr.size();i++){
           if(arr.get(i)==0)z++;
           else if(arr.get(i)==1)o++;
           else{
               t++;
           }
       }
       int k=0;
       while(z>0 || o>0 || t>0){
           if(z>0){
               arr.set(k,0);
               k++;
               z--;
           }
           else if(o>0){
               arr.set(k,1);
               k++;
               o--;
               
           }
           else if(t>0){
               arr.set(k,2);
               k++;
               t--;
               
           }
       }
    }
}