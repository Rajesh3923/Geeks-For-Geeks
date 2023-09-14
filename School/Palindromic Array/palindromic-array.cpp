//{ Driver Code Starts
#include<iostream>
#include<string.h>
using namespace std;


// } Driver Code Ends
/*Complete the function below*/

class Solution {
public:
    bool pali(int x){
        string neww= to_string(x);
        for(int i=0;i<neww.length();i++){
            if(neww[i]!=neww[neww.length()-i-1]){
                return false;
            }
        }return true;
    }


    int PalinArray(int a[], int n)
    {
        for (int i=0;i<n;i++){
          if(!(pali(a[i]))){
              return 0;
          }
        }return 1;
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
		for(int i = 0; i < n; i++)
			cin>>a[i];
		Solution obj;
		cout<<obj.PalinArray(a,n)<<endl;
	}
}
// } Driver Code Ends