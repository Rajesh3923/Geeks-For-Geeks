//{ Driver Code Starts
// Initial template for JAVA

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        // taking input using class Scanner
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // taking total number of elements
            int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            ArrayList<Integer> res = new Solution().max_of_subarrays(k, arr);

            // printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function template for JAVA



class Solution {
    // Function to find maximum of each subarray of size k.
    public ArrayList<Integer> max_of_subarrays(int k, int arr[]) {
        ArrayList<Integer> al = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a)); // Max-Heap
        HashMap<Integer, Integer> outOfWindowMap = new HashMap<>(); // To keep track of outdated elements

        int r = 0;
        for (r = 0; r < k; r++) {
            pq.add(arr[r]); // Add the first k elements
        }
        
        int l = 0;
        al.add(pq.peek()); // Add the max of the first window
        
        for (int i = r; i < arr.length; i++) {
            // Add the new element into the window
            pq.add(arr[i]);
            
            // Mark the element going out of the window for lazy removal
            outOfWindowMap.put(arr[l], outOfWindowMap.getOrDefault(arr[l], 0) + 1);
            
            // Remove outdated elements lazily from the top of the heap
            while (!pq.isEmpty() && outOfWindowMap.containsKey(pq.peek()) && outOfWindowMap.get(pq.peek()) > 0) {
                outOfWindowMap.put(pq.peek(), outOfWindowMap.get(pq.peek()) - 1);
                pq.poll(); // Remove the outdated max element
            }

            al.add(pq.peek()); // Add the current max
            l++; // Move the window
        }
        
        return al;
    }
}



// int max=Integer.MIN_VALUE;
//         for(int i=0;i<k;i++){
//             max=Math.max(max,arr[i]);
//         }
//         al.add(max);
//         int l=1;
//         int r=l+k;
//         while(r<=arr.length){
//             int [] nn=Arrays.copyOfRange(arr,l,r);
//              max = Arrays.stream(nn) // Convert array to stream
//                 .max()       // Get the maximum value from the stream
//                 .getAsInt(); // Extract the value from OptionalInt
//             al.add(max);
//             l++;
//             r++;

           
//         }
//         return al;