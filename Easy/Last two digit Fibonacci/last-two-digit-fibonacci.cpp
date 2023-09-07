//{ Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function template for C++

class Solution{
    public:
    int fibonacciDigits(long long N){
      long long arr[300];
      //after 300 every last two digit are repeated
arr[1] = 1;
arr[2] = 1;
for (int i = 3; i < 300; i++)
arr[i] = (arr[i-2]+arr[i-1]) % 100;

return arr[N %300];
   }
};

//{ Driver Code Starts.
int main(){
    int t;
    cin>>t;
    while(t--){
        long long N;
        cin>>N;
        Solution ob;
        int ans=ob.fibonacciDigits(N);
        if(ans/10)
         cout<<ans;
        else
         cout<<0<<ans;
        cout<<"\n";  
    }
}
// } Driver Code Ends