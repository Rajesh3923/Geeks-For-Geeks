//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG{

    public int maxLen(int arr[], int n) {
        // Initialize variables
        HashMap<Integer, Integer> sumIndexMap = new HashMap<>();
        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            // Add current element to sum
            sum += arr[i];

            // Check if the sum is zero, meaning we found a subarray from the start
            if (sum == 0) {
                maxLen = i + 1;
            }

            // Check if the sum has been seen before
            if (sumIndexMap.containsKey(sum)) {
                // Update maxLen if we found a longer subarray with sum 0
                maxLen = Math.max(maxLen, i - sumIndexMap.get(sum));
            } else {
                // Store the first occurrence of the sum
                sumIndexMap.put(sum, i);
            }
        }

        return maxLen;
    }


}

