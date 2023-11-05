//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

  

// } Driver Code Ends
// Function to find square root
// x: element to find square root
class Solution{
  public:
    long long int floorSqrt(long long int x) 
    {
          long long l=0;long long h=x;int a;
          while(l<=h){
              long long m=(l+h)/2;
              long long mv=m*m;
              if(mv<=x){
                  a=m;
                  l=m+1;
              }else{
                  h=m-1;
              }
          }return a;
    }
};

//{ Driver Code Starts.

int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		long long n;
		cin>>n;
		Solution obj;
		cout << obj.floorSqrt(n) << endl;
	}
    return 0;   
}

// } Driver Code Ends