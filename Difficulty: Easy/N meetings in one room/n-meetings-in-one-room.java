//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class Sort {
    int s;
    int e;
    public Sort(int s, int e){
        this.s = s;
        this.e = e;
    }
}

class Solution {
    // Function to find the maximum number of meetings that can be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n) {
        Sort[] sort = new Sort[n];
        for (int i = 0; i < n; i++) {
            sort[i] = new Sort(start[i], end[i]);
        }
        Arrays.sort(sort, (x, y) -> Integer.compare(x.e, y.e));
        
        int c = 1;
        int prev = sort[0].e;
        
        for (int i = 1; i < sort.length; i++) {
            if (sort[i].s > prev) {
                c++;
                prev = sort[i].e;
            }
        }
        return c;
    }
}
        
        
        
