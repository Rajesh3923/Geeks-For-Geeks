//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;

    Item(int x, int y) {
        this.value = x;
        this.weight = y;
    }
}

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0, k = 0; i < n; i++) {
                arr[i] = new Item(Integer.parseInt(inputLine[k++]),
                                  Integer.parseInt(inputLine[k++]));
            }
            System.out.println(
                String.format("%.6f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}
// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y) {
        this.value = x;
        this.weight = y;
    }
}

*/

class Solution {
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) {
        // Create an array of Double to store the value/weight ratio
        // Double[] ratio = new Double[n];
        
        // for (int i = 0; i < n; i++) {
        //     ratio[i] = (double) arr[i].value / arr[i].weight;
        // }
        
        // Sort items by value per weight in descending order
        Arrays.sort(arr, (a, b) -> Double.compare((double) b.value / b.weight, (double) a.value / a.weight));
        
        double totalValue = 0.0;
        int remainingCapacity = W;

        // Iterate through sorted items
        for (Item item : arr) {
            if (remainingCapacity - item.weight >= 0) {
                // This weight can be fully added
                remainingCapacity -= item.weight;
                totalValue += item.value;
            } else {
                // This weight can't be fully added, add fractional part
                totalValue += (double) item.value * remainingCapacity / item.weight;
                break;
            }
        }

        return totalValue;
    }
}