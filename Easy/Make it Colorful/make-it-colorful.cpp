//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++

class Solution{
public:
    vector<int> extraCount(string s){
        vector<int>v;
        map<char,int>m;
        for(int i=0;i<s.size();i++)
            {
                m[s[i]]++;
            }
        v.push_back(s.size()/4-m['R']);
        v.push_back(s.size()/4-m['B']);
        v.push_back(s.size()/4-m['Y']);
        v.push_back(s.size()/4-m['G']);
        return v;
    }
    
};

//{ Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        string s;
        cin>>s;
        
        Solution ob;
        vector<int> res = ob.extraCount(s);
        cout<<"R"<<res[0]<<"B"<<res[1]<<"Y"<<res[2]<<"G"<<res[3]<<"\n";
    }
    return 0;
}
// } Driver Code Ends