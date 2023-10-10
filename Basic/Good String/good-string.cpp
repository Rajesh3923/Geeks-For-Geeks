//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;
string isGoodString(string s);
int main()
{
	int t;
	cin>>t;
	while(t--)
	    {
	       string s;
	       cin>>s;
	       cout<<isGoodString(s)<<endl;
	    }
}	    
	    
// } Driver Code Ends

string isGoodString(string s)
{
    //may2021
    
    for(int i=1 ; i<s.size() ; i++)
      {
          if(abs(s[i]-s[i-1]) !=1 && abs(s[i]-s[i-1]) !=25 )
            return "NO";
          
      }
    
    return "YES";
    
}