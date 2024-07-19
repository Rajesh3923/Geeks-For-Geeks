//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int arr[] = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }

            int[] ans = new Solution().constructLowerArray(arr);
            for (int i = 0; i < arr.length; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
   public static int[] constructLowerArray(int[] arr) {
        int n = arr.length;
        Integer[] result = new Integer[n];
        List<Integer> sortedList = new ArrayList<>();

        for (int i = n - 1; i >= 0; i--) {
            int count = findInsertPosition(sortedList, arr[i]);
            result[i] = count;
            sortedList.add(count, arr[i]);
        }

        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
    }

    private static int findInsertPosition(List<Integer> sortedList, int target) {
        int low = 0;
        int high = sortedList.size();

        while (low < high) {
            int mid = (low + high) / 2;
            if (sortedList.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}