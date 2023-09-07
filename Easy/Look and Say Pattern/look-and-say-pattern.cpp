//{ Driver Code Starts
//Initial template for C++

#include<bits/stdc++.h> 
using namespace std;

// } Driver Code Ends
//User function template for C++

class Solution
{
  public:
   string lookandsay(int n) {
        if( n == 0 ) return "";
        string ans = "1";
        if( n == 1 ) return ans;
        n = n-1; // starting from n=2
        while(n--) {
            string t = "" ;
            for(int i=0 ; i<ans.size() ; i++) {
                int cnt = 1;
                while(i < ans.size()-1 && ans[i] == ans[i+1]) {
                    cnt++;
                    i++;
                }
                t += to_string(cnt) + ans[i];
            }
            ans = t;
        }
        return ans;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin>>t;
    while(t--)
    {
        int n;
        cin>>n;
        Solution obj;
        cout<<obj.lookandsay(n)<<endl;
    }
    return 0;
}
// } Driver Code Ends