//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++

class Solution{
public:
   
      vector<string> pattern(int n){
    vector<string> res(n);
    int left = 1, right = n * (n + 1);
    for(int x = 0; x < n; x++){
        string l_str = string(x * 2, '-'), r_str = "";
        int t = n - x;
        while(t--){
            l_str += to_string(left++);
            l_str += '*';
            r_str = to_string(right--) + r_str;
            r_str = '*' + r_str;
        }
        r_str = r_str.substr(1);
        res[x] = l_str + r_str;
    }
    return res;
}
};

//{ Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int n;
        cin>>n;
        
        Solution ob;
        vector<string> ans = ob.pattern(n);
        for(int i = 0;i < n;i++)
            cout<<ans[i]<<"\n";
    }
    return 0;
}
// } Driver Code Ends