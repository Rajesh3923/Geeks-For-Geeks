//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.ArrayList;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.getPrimes(n);

            IntArray.print(res);
        }
    }
}

// } Driver Code Ends



class Solution {
     public static ArrayList<Integer> getPrimes(int n) {
        ArrayList<Integer> primes = findPrimes(n);
        HashMap<Integer, Integer> primeMap = new HashMap<>();

        // Populate the HashMap with primes
        for (int prime : primes) {
            primeMap.put(prime, 0);
        }

        // Initialize the result array
        List<int[]> res = new ArrayList<>();
        
        // Find pairs of primes that sum up to n
        for (int prime : primes) {
            if (primeMap.containsKey(n - prime)) {
                res.add(new int[]{prime, n - prime});
            }
        }

        // If no pairs found, return {-1, -1}
        if (res.size() == 0) {
            return new ArrayList<>(List.of(-1, -1));
        }

        // Find the pair with the largest first element
        int[] bestPair = res.get(0);
        for (int[] pair : res) {
            if (pair[0] > bestPair[0]) {
                bestPair = pair;
            }
        }

        return new ArrayList<>(List.of(bestPair[1], bestPair[0]));
    }

    public static ArrayList<Integer> findPrimes(int n) {
        ArrayList<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
}
