//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> arr = new ArrayList<>();

            for (String s : inputArray) {
                arr.add(Integer.parseInt(s));
            }

            new Solution().rearrange(arr);
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    void rearrange(ArrayList<Integer> arr) {
       ArrayList<Integer>p=new ArrayList<>();
       ArrayList<Integer>n=new ArrayList<>();
        for(int i=0;i<arr.size();i++){
            if(arr.get(i)>=0){
                p.add(arr.get(i));
            }
            else{
                n.add(arr.get(i));
            }
        }
        int k=0;int ps=0;int ns=0;
        for(int i=0;i<arr.size();){
            if(ps<p.size()){
                arr.set(i++,p.get(ps));
                ps++;
            }
            if(ns<n.size()){
                arr.set(i++,n.get(ns));
                ns++;
            }
        }
        
    }
}