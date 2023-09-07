//{ Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends

class Solution {
  public:
   vector<string> revCharBridge(int N) {
        // code here
        vector<string>ans;
        for(int i=0;i<N;i++){
            string row="";
            for(int j=0;j<N-i;j++){
                row+=char(j+'A');
            }
            for(int j=0;j<(2*(i))-1;j++){
                row+=' ';
            }
            for(int j=(i==0)?N-2:N-i-1;j>=0;j--){
                row+=char(j+'A');
            }
            ans.push_back(row);
        }
        return ans;
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
        vector<string> v = ob.revCharBridge(N);
        
        for(int i=0; i<v.size(); i++)
            cout<<v[i]<<endl;
    }
    return 0;
}
// } Driver Code Ends