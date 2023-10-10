//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

bool decode (string s);
int main()
{
    int t; cin >> t;
    while (t--)
    {
        string s; cin >> s;

        cout << decode (s) << endl;
    }
}
// Contributed By: Pranay Bansal

// } Driver Code Ends


bool decode (string S)
{
    int count =0;
    for(int i=0; i<S.length(); i++){
        
        if(count==0 && S[i]=='h'){
            count++;
        }
        else if(count ==1 && S[i]=='e'){
            count++;
        }
        else if(count ==2 && S[i]=='l'){
            count++;
        }
        else if(count ==3 && S[i]=='l'){
            count++;
        }
        else if(count ==4 && S[i]=='o'){
            count++;
        }
        
      
    }
    if(count ==5){
            return true;
    }
    return false;
}