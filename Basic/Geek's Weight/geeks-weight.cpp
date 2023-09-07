//{ Driver Code Starts

#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends

class Solution{
	public:
   long long int total_Money(int n, int k){
           // may2021
           
           long long int result=(n/k);
                         result*=(n/k+1);
                         result/=2;
                         result*=k;
           return result;
       }   
};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n, k;
		cin >> n >> k;
		Solution ob;
		long long int ans = ob.total_Money(n, k);
		cout << ans <<"\n";
	}  
	return 0;
}
// } Driver Code Ends