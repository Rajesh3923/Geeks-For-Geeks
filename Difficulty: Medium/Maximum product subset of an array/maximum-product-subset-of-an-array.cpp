//{ Driver Code Starts
/* Driver program to test above function */

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++
#define ll long long int 
class Solution {
  public:
  
    ll MOD = 1e9 + 7 ;
    long long int findMaxProduct(vector<int>& arr) {
        
        ll prod = 1;
        ll maxNegative = INT_MIN ;
        for(auto ele:arr){
            
            if(ele != 0)  prod = (prod*(ele)%MOD)%MOD;
            
            if(ele < 0) maxNegative = max(maxNegative,(ll)ele);
        }
        
        if(prod < 0) prod = prod / maxNegative ;
        
        return prod ;
     }
};


//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        vector<int> arr(n);
        for (int i = 0; i < n; i++) {
            cin >> arr[i];
        }
        Solution ob;
        long long int ans = ob.findMaxProduct(arr);
        cout << ans << endl;
    }
    return 0;
}

// } Driver Code Ends