//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends

//Function to find the maximum possible amount of money we can win.
// Tabulation
#define ll long long
class Solution{
    public:
    long long maximumAmount(int n, int arr[]){
        vector<vector<ll>> dp(n,vector<ll>(n,0));
        
        //base case is - i>j mark all boxes equal to 0
        for(int i=n-1;i>=0;i--)
        {
            for(int j=0;j<n;j++)
            {
                //if i>j , it's a base case , make it 0
                if(i>j)
                {
                    dp[i][j]=0;
                    continue;
                }
                
                ll a=arr[i];
                ll b=arr[j];
                
                //1st case
                ll c=i+2<n? dp[i+2][j] : 0;
                ll d=(i+1<n) and (j-1>=0) ? dp[i+1][j-1] : 0;
            
                //2nd case
                ll e=j-2>=0 ? dp[i][j-2] : 0;
                ll f=(i+1<n) and (j-1>=0) ? dp[i+1][j-1] : 0;
        
                a+=min(c,d);
                b+=min(e,f);
                
                dp[i][j]=max(a,b);
            }
        }
        return dp[0][n-1];
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
		int a[n];
		for(int i=0;i<n;i++)
		cin>>a[i];
		Solution ob;
		cout<< ob.maximumAmount(n,a)<<endl;
	}
	return 0;
}
// } Driver Code Ends