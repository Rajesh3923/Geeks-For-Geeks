//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the remaining newline

        for (int k = 0; k < t; k++) {
            List<Integer> arr1 = new ArrayList<>();
            String input = sc.nextLine();
            Scanner lineScanner = new Scanner(input);
            while (lineScanner.hasNextInt()) {
                arr1.add(lineScanner.nextInt());
            }
            lineScanner.close();

            List<Integer> arr2 = new ArrayList<>();
            input = sc.nextLine();
            lineScanner = new Scanner(input);
            while (lineScanner.hasNextInt()) {
                arr2.add(lineScanner.nextInt());
            }
            lineScanner.close();

            Solution ob = new Solution();
            int ans = ob.maxPathSum(arr1, arr2);
            System.out.println(ans);
        }

        sc.close();
    }
}

// } Driver Code Ends




class Solution {
    public int maxPathSum(List<Integer> arr1, List<Integer> arr2) {
        int m = arr1.size();
        int n = arr2.size();
        int i = 0, j = 0;
        int sum1 = 0, sum2 = 0;
        int result = 0;

        while (i < m && j < n) {
            // Add current elements to respective sums
            if (arr1.get(i) < arr2.get(j)) {
                sum1 += arr1.get(i);
                i++;
            } else if (arr1.get(i) > arr2.get(j)) {
                sum2 += arr2.get(j);
                j++;
            } else {
                // Common element found
                result += Math.max(sum1, sum2) + arr1.get(i);
                sum1 = 0;
                sum2 = 0;
                i++;
                j++;
            }
        }

        // Add remaining elements from arr1
        while (i < m) {
            sum1 += arr1.get(i++);
        }

        // Add remaining elements from arr2
        while (j < n) {
            sum2 += arr2.get(j++);
        }

        // Add the maximum of remaining sums
        result += Math.max(sum1, sum2);

        return result;
    }
}
