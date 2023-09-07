//{ Driver Code Starts
//Initial Template for C++

#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function Template for C++

class Solution{
	public:
   	  int Nth_rowSum(int n){
    int sum = 0;
    int start = n*(n-1) +1;
    int end = n*(n-1) +1 + n*2;
    for(int i = start; i< end; i++){
        sum = (sum + i)%1000000007;
    }
    return sum;
    }       
};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n;
		cin >> n;
		Solution ob;
		int ans = ob.Nth_rowSum(n);
		cout << ans <<"\n";
	}  
	return 0;
}
// } Driver Code Ends