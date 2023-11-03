//{ Driver Code Starts
//Initial Template for C++

#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function Template for C++

class Solution{
	public:
   	long long int prime_Sum(int A){
   	    // Code here
   	    bool p[A+1];
   	    long long int s = 0;
        p[0]=false;p[1]=false;
        for(int i=2;i<=A;i++)
            p[i] = A;
        for(int i=2;i*i<=A;i++)
            if(p[i]==true)
                for(int j=2*i;j<=A;j=j+i)
                    p[j]=false;
        for(int i=2;i<=A;i++)
            if(p[i]==true)
                s += i;
        return s;
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
		long long int ans = ob.prime_Sum(n);
		cout << ans <<"\n";
	}  
	return 0;
}
// } Driver Code Ends