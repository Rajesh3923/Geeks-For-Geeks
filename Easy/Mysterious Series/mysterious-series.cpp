//{ Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++
class Solution {
  public:
    long long nthMysterious(long long N){
        // code here
        int n = 1e5;
        long long sieve[n+1];
        for(int i=0;i<=n;++i){
            if(i==0 || i==1) sieve[i] = false;
            else sieve[i] = true;
        }
        
        for(int i=2;i*i<=n;++i){
            if(sieve[i]){
                for(int j=i*i;j<=n;j+=i){
                    sieve[j] = false;
                }
            }
        }
        
        vector<long long> primes;
        for(int i=2;i<=n;++i){
            if(sieve[i]) primes.push_back(i);
        }
        
        return (primes[N-1]*primes[N-1])+1;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        long long N;
        cin >> N;
        Solution ob;
        cout << ob.nthMysterious(N) << endl;
    }
    return 0;
}

// } Driver Code Ends