//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>

using namespace std;


// } Driver Code Ends
//User function template for C++
class Solution{
public:
bool fascinating(int n) {
    long s = n;
    string str = to_string(n) + to_string(2 * n) + to_string(3 * n);
    
    // Check if the concatenated string contains all digits from 1 to 9 exactly once
    if (str.length() != 9) {
        return false;
    }

    for (char digit = '1'; digit <= '9'; digit++) {
        if (str.find(digit) == string::npos) {
            return false;
        }
    }

    return true;
}
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        Solution ob;
        auto ans = ob.fascinating(n);
        if (ans) {
            cout << "Fascinating\n";
        } else {
            cout << "Not Fascinating\n";
        }
    }
    return 0;
}
// } Driver Code Ends