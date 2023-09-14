//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution
{
    public:
    //Function to check if brackets are balanced or not.
    bool ispar(string x) {
    stack<char> s;
    for (char chars : x) {
        if (chars == ')' || chars == ']' || chars == '}') {
            // Check if the stack is empty before accessing 's.top()'
            if (s.empty() || (chars == ')' && s.top() != '(') || (chars == '}' && s.top() != '{') || (chars == ']' && s.top() != '[')) {
                return false;
            }
            // If it's a matching closing parenthesis, pop it from the stack
            s.pop();
        } else {
            // If it's an opening parenthesis, push it onto the stack
            s.push(chars);
        }
    }
    // At the end, if the stack is empty, all parentheses were matched, return 'true'; otherwise, return 'false'.
    return s.empty();
}


};

//{ Driver Code Starts.

int main()
{
   int t;
   string a;
   cin>>t;
   while(t--)
   {
       cin>>a;
       Solution obj;
       if(obj.ispar(a))
        cout<<"balanced"<<endl;
       else
        cout<<"not balanced"<<endl;
   }
}
// } Driver Code Ends