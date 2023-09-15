//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution{
    public:
    int Maximize(int a[],int n){
    sort(a, a + n);
    long long s = 0; // Use a long long to avoid overflow
    const int MOD = 1000000007;

    for (int i = 0; i < n; i++) {
        s = (s + 1LL * a[i] * i) % MOD; // Use 1LL to ensure long long multiplication
    }
    
    return static_cast<int>(s); }
};

//{ Driver Code Starts.
int main(){

    int t;
    cin>>t;
    while(t--){
        int n;
        cin>>n;
        int a[n];
        for(int i=0;i<n;i++)
            cin>>a[i];
        Solution ob;
        cout<<ob.Maximize(a,n)<<endl;
    }
}
// } Driver Code Ends