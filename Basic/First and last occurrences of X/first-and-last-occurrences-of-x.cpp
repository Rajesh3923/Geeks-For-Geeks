//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
  public:

vector<int> firstAndLast(vector<int> &arr, int n, int x) {
    vector<int> result;
    int left = 0;
    int right = n - 1;
    int first = -1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] == x) {
            first = mid;
            right = mid - 1; 
        } else if (x < arr[mid]) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }

    if (first == -1) {
        // x is not in the array
        result.push_back(-1);
        return result;
    }

    left = 0;
    right = n - 1;
    int last = -1;

    // Find the last occurrence of x
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] == x) {
            last = mid;
            left = mid + 1; // Continue searching to the right
        } else if (x < arr[mid]) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }

    // Populate the result vector with first and last occurrences
    result.push_back(first);
    result.push_back(last);
    return result;
}

};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, x;
        cin >> n >> x;
        vector<int> arr(n);
        for (int i = 0; i < n; i++) {
            cin >> arr[i];
        }

        Solution obj;
        vector<int> ans= obj.firstAndLast(arr, n, x) ;
        for(int i:ans){
            cout<<i<<" ";
        }
        cout<< endl;
    }
    return 0;
}

// } Driver Code Ends