//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution{
public:
   int findMin(int arr[], int n) {
    int l = 0;
    int h = n - 1;
    int ans = INT_MAX;

    while (l <= h) {
        int m = (l + h) / 2;

        if (arr[l] < arr[h]) {
            ans = min(ans, arr[l]);
            break;
        } else if (arr[l] <= arr[m]) {
            ans = min(ans, arr[l]);
            l = m + 1;
        } else if (arr[m] <= arr[h]) {
            ans = min(ans, arr[m]);
            h = m - 1;
        }
    }

    return ans;
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
		int i,a[n];
		for(i=0;i<n;i++)
		{
			cin>>a[i];
		}
		Solution ob;
		cout<<ob.findMin(a, n)<<endl;
	}
	return 0;
}
// } Driver Code Ends