//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim()); // size of array
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]); // input elements of array
		    }
		    
		    Solution ob = new Solution();
		    
		    System.out.println(ob.maxIndexDiff(arr, n)); // print the result
		}
	}
}
// } Driver Code Ends


class Solution {
    static int maxIndexDiff(int[] A, int N) {
        int[] leftMin = new int[N];
        int[] rightMax = new int[N];
        
        // Fill leftMin array
        leftMin[0] = A[0];
        for (int i = 1; i < N; i++) {
            leftMin[i] = Math.min(A[i], leftMin[i - 1]);
        }
        
        // Fill rightMax array
        rightMax[N - 1] = A[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            rightMax[i] = Math.max(A[i], rightMax[i + 1]);
        }
        
        int i = 0, j = 0, maxDiff = -1;
        while (i < N && j < N) {
            if (leftMin[i] <= rightMax[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j++;
            } else {
                i++;
            }
        }
        
        return maxDiff;
    }
}



