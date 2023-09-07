//{ Driver Code Starts
#include <iostream>
using namespace std;

void printPattern(string s);

int main() {
	// your code goes here
	int t;
	cin>>t;
	while(t--)
	{
	string s;
	cin>>s;
	printPattern(s);
	cout<<endl;
	
}
	
	return 0;
}
// } Driver Code Ends


/*method prints the given pattern in a single line */
void printPattern( string s ) {
    s = s.substr( s.size() / 2 ) + s.substr( 0, s.size() / 2 );
    for ( size_t i{ 1 }; i <= s.size(); ++i )
        cout << s.substr( 0, i ) + "$ ";
}