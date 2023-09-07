//{ Driver Code Starts
//Initial Template for C++
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function Template for C++
class Solution {
  public:
      bool isPrime(int n){
      for(int i=2;i<=sqrt(n);i++){
          if(n%i==0){
              return false;
          }
      }
      return true;
  }
    int nthTerm(int n){
        int i=0;
        int ans=0;
        for(int num=2;i<n;num++){
            if(isPrime(num)){
                ans=num;
                i++;
            }
        }
        return (ans+1)*n;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int  n;
        cin >> n;
        Solution ob;
        cout<<ob.nthTerm(n)<<endl;
    }
    return 0;
}

// } Driver Code Ends