//{ Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function Template for C++

class Solution {
  public:
        vector<string> findThePattern(int N) {
        // code here
         vector<string> result;
        string temp="";
        int k=0;
        
        for(int i=0 ; i<N ; i++)
         {
             temp="";
             for(int j=0 ; j<N ; j++)
              {
                  if(i!=0 && i!=N-1 && j!=0 && j!=N-1)
                     temp+='$';
                  else
                    {
                     char c='A'+k;
                     temp+=c;
                     k++;
                    }

              }
              result.push_back(temp);
         }
        
        return result;
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
        vector<string> v = ob.findThePattern(N);
        
        for(int i=0; i<v.size(); i++)
            cout<<v[i]<<endl;
    }
    return 0;
}
// } Driver Code Ends