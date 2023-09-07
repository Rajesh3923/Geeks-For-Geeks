//{ Driver Code Starts
#include<bits/stdc++.h> 
using namespace std; 

// } Driver Code Ends
class Solution
{
public:
   vector<long long> printSeries(int N){
        // Write your code here
        int n = 100;
        long long a[n];
        a[0] = 1,a[1] = 2,a[2] = 5;
        for(int i=3;i<n;++i){
            a[i] = a[i-1]+a[i-2]+a[i-3];
        }
        vector<long long> ans;
        for(int i=0;i<N;++i){
            ans.push_back(a[i]);
        }
        return ans;
    }
};

//{ Driver Code Starts.
int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int N;
        cin >> N;
        
        Solution ob;
        vector<long long> a = ob.printSeries(N);
        
        for(long long i=0;i<N;i++){
            cout<<a[i]<<" ";
        }
        cout<<endl;
        
    }
    return 0;
}
// } Driver Code Ends