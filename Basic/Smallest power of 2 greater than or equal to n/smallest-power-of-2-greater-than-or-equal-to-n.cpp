//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution{
    public:
    int no_of_bits(long long n){
        int ct=0;
        while(n>0){
            ct++; 
            n = n>>1;
        }
        return ct;
    }
    long long nearestPowerOf2(long long N){
        //code here
        int bits=no_of_bits(N);
        if((N&(N-1))==0)return N;
        else return (1LL<<bits);
    }
};

//{ Driver Code Starts.
int main(){
    int t;
    cin>>t;
    while(t--)
    {
        long long N;
        cin>>N;
        Solution ob;
        cout<<ob.nearestPowerOf2(N)<<"\n";
    }
}
// } Driver Code Ends