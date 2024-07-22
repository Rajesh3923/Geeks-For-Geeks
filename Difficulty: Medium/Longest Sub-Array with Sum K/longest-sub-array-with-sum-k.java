//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    int K = Integer.parseInt(element[1]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    int res = obj.lenOfLongSubarr(arr, sizeOfArray, K);
		    
		    System.out.println(res);
		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution{
    
   
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr(int A[], int N, int K) {
        // HashMap to store (cumulative sum, index)
        HashMap<Integer, Integer> map = new HashMap<>();
        int currentSum = 0;
        int maxLength = 0;

        for (int i = 0; i < N; i++) {
            // Add the current element to the cumulative sum
            currentSum += A[i];

            // Check if currentSum is equal to K
            if (currentSum == K) {
                maxLength = i + 1;
            }

            // Check if (currentSum - K) exists in the map
            if (map.containsKey(currentSum - K)) {
                maxLength = Math.max(maxLength, i - map.get(currentSum - K));
            }

            // If currentSum is not already present in the map, add it
            if (!map.containsKey(currentSum)) {
                map.put(currentSum, i);
            }
        }

        return maxLength;
    }

    
    
}


