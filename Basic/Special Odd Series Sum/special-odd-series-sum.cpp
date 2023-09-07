//{ Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++
class Solution {
  public:
   long long int sumOfTheSeries(long long int n){
       
       int sum = 0;
       int count = 0;
       for(int i=1; i<=n*2; i=i+2) {
           sum = sum + i;
           count = count + sum;
       }
       return count;
   }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        long long int n;
        cin >> n;
        Solution ob;
        cout << ob.sumOfTheSeries(n) << endl;
    }
    return 0;
}

// } Driver Code Ends