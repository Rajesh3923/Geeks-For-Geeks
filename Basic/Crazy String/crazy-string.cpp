//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;
string getCrazy (string s);
int main()
{
    int t; cin >> t;
    while (t--)
    {
        string S; cin >> S;

        cout << getCrazy (S) << endl;
    }
}

// Contributed By: Pranay Bansal

// } Driver Code Ends


string getCrazy (string S)  {
    for(int i=1; i<S.length(); i++) {
        if(islower(S[0])) {
            if(i%2 == 0)
                S[i] = tolower(S[i]);
            else
                S[i] = toupper(S[i]);
        }
        else {
            if(i%2 == 0)
                S[i] = toupper(S[i]);
            else
                S[i] = tolower(S[i]);
        }
    }
    return S;
}