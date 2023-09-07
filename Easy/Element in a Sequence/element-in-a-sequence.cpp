//{ Driver Code Starts
#include<bits/stdc++.h> 
using namespace std; 

// } Driver Code Ends
//User function Template for C++
class Solution
{
public:
    int NthTermOfSeries(int N)
    {
        int ans = 0;
        int count = 1;
        while(N){
            int ele = N%2 == 0 ? 7 : 4;
            ans = count*ele + ans;
            count *= 10;
            
            if(N%2 == 0){
                N = (N - 2)/2;
            }
            else
                N /= 2;
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
        int N;
        cin>>N;
        Solution ob;
        int ans  = ob.NthTermOfSeries(N);
        cout<<ans<<endl;
    }
    return 0;
}
// } Driver Code Ends