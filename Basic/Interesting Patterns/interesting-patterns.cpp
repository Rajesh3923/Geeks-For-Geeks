//{ Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function Template for C++

class Solution {
  public:
    vector<string> interestingPattern(int N) {
        vector<string> v;
        int n=N*2-1;
        for(int i=1;i<=n;i++)
        {
            string s="";
            for(int j=1;j<=n;j++)
            {
                int k=max(abs(i-N),abs(j-N))+1;
                s+=to_string(k);
            }
            v.push_back(s);
        }
        return v;
        // code here
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int N;
        
        cin>>N;

        Solution ob;
        vector<string> v = ob.interestingPattern(N);
        
        for(int i=0; i<v.size(); i++)
            cout<<v[i]<<endl;
    }
    return 0;
}
// } Driver Code Ends