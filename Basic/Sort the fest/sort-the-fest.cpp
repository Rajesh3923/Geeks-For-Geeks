//{ Driver Code Starts
//Initial Template for C++


#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends


class Solution
{
	public:
	string is_common(vector<string>&s, vector<string>&t)
{
    //may2021 
   unordered_set<string>m;
 
   for(int i=0;i<5;i++)
   {
       m.insert(s[i]);
   }
 
   for(int i=0;i<5;i++)
   {
      if(m.find(t[i]) != m.end())
      {
          return "CHANGE";
      }
   }
   return "BEHAPPY";    
}
};

//{ Driver Code Starts.
int main(){
    int T;
    cin >> T;
    while(T--)
    {
	    vector<string> s(5), t(5);
	    for(int i = 0; i < 5; i++)
	    	cin >> s[i];
	    for(int i = 0; i < 5; i++)
	    	cin >> t[i];
	    Solution ob;
	    string ans = ob.is_common(s, t);
	    cout << ans <<"\n";
    }
	return 0;
}
// } Driver Code Ends