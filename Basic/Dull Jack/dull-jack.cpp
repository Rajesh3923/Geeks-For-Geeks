//{ Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++
class Solution {
  long long power(long long a, long long n){

        long long int m = 1000000007;

        long long int res = 1;

        while(n>0){

            if(n%2!=0){

                res = (res * a) % m;

            }

            a = (a * a) % m;

            n /= 2;

        }

        return res;

    }

  public:

    long long nthDayPage(long long N, long long K){

        return power(K, (N-1));

    }

 
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        long long N, K;
        cin >> N >> K;
        Solution ob;
        cout<<ob.nthDayPage(N, K)<<endl;
    }
    return 0;
}

// } Driver Code Ends