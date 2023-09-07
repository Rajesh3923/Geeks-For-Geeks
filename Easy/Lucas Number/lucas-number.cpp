//{ Driver Code Starts
#include <iostream>
using namespace std;

// } Driver Code Ends
class Solution
{
    public:
        long long lucas(int n)
       {
           //code here.
           long long dp[n+1];
           for(int i=0;i<=n;i++){
               dp[i]=-1;
           }
           dp[0]=2;
           dp[1]=1;
           for(int i=2;i<=n;i++){
               dp[i]=(dp[i-1]+dp[i-2])%1000000007;
           }
           return dp[n];
       }


        
};


//{ Driver Code Starts.
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		int n;
		cin>>n;
		Solution ob;
		cout<<ob.lucas(n)<<endl;
	}
	return 0;
}
// } Driver Code Ends