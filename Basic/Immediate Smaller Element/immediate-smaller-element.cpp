//{ Driver Code Starts
#include <bits/stdc++.h>

using namespace std;

// } Driver Code Ends
//User function template for C++
class Solution{
public:	
	void immediateSmaller(vector<int>&arr, int n) {
	      int prev = -1;
	    for(int i=n-1;i>=0;i--)
	    {
	        if(prev==-1)
	        {
	            prev = arr[i];
	            arr[i] = -1;
	        }
	        else
	        {
	            if(prev<arr[i])
	            {
	                int temp = arr[i];
	                arr[i] = prev;
	                prev = temp;
	            }
	            else
	            {
	                prev = arr[i];
	                arr[i] = -1;
	            }
	        }
	    }
	}

};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, l, r;
        cin >> n;
        vector<int>arr(n);
        for (int i = 0; i < n; i++) {
            cin >> arr[i];
        }
        Solution ob;
        ob.immediateSmaller(arr, n);
        for (int i = 0; i < n; i++) {
            cout << arr[i] << " ";
        }
        cout << "\n";
    }
    return 0;
}

// } Driver Code Ends