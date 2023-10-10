//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;
string ExtractMessage(string s);
int main()
{
	int t;
	cin>>t;
	while(t--)
	    {
	        string s;
	        cin>>s;
	        cout<<ExtractMessage(s)<<endl;
	    }
}
// } Driver Code Ends


string ExtractMessage( string s ) {
    string r;
    for ( size_t i{}; i < s.size(); ++i )
        if ( s.substr( i, 3 ) == "LIE" )
            r += r.back() == ' ' ? "" : " ", i += 2;
        else r += s[ i ];
    return r.substr( r.front() == ' ' );
}
