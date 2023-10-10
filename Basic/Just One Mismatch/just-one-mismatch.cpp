//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
  public:
   string isStringExist( vector< string > a, int n, string s ) {
    for ( const auto& S : a ) if ( S.size() == s.size() ) {
        int c{};
        for ( size_t i{}; i < s.size(); ++i )
            if ( S[ i ] != s[ i ] && ++c > 1 ) break;
        if ( c == 1 ) return "True";
    }
    return "False";
}
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        string s;
        vector<string> v;
        for (int i = 0; i < n; i++) {
            cin >> s;
            v.push_back(s);
        }
        string g;
        cin >> g;
        Solution ob;
        cout << ob.isStringExist(v, n, g) << "\n";
    }
    return 0;
}
// } Driver Code Ends