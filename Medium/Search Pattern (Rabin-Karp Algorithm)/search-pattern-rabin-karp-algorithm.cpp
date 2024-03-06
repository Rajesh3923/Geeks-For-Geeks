//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution
{
    public:
        vector <int> search(string pat, string txt)
        {
            //code here.
          
            vector<int> ans;
            
            for(int i = 0 ; i < txt.size() ; i++){
                int ptr = i;
                int j = 0;      
                
                while(pat[j] == txt[i] and j < pat.size()){
                    i++;
                    j++;
                }
                if(j == pat.size()){
                    ans.push_back(ptr+1);
                }
                    i = ptr;
            }
            
            return ans;
            
        }
     
};

//{ Driver Code Starts.
int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        string S, pat;
        cin >> S >> pat;
        Solution ob;
        vector <int> res = ob.search(pat, S);
        for (int i : res) cout << i << " ";
        cout << endl;
    }
    return 0;
}

// Contributed By: Pranay Bansal

// } Driver Code Ends