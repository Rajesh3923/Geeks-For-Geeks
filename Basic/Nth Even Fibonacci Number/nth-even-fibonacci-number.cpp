//{ Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++
class Solution {
  public:
    long long int nthEvenFibonacci(long long int N) 
    {
     
     //may2021
     long long int f=1, s=1, temp=0;
     
     for(int i=3 ; i<=3*N ; i++)
      {
          temp=f+s;
          f=s;
          s=temp%1000000007;
      }
      
      return s;
    
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
        cout << ob.nthEvenFibonacci(n) << endl;
    }
    return 0;
}

// } Driver Code Ends