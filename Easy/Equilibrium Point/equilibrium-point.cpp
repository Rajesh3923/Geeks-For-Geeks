//{ Driver Code Starts
#include <iostream>
using namespace std;


// } Driver Code Ends
class Solution{
    public:
    // Function to find equilibrium point in the array.
    // a: input array
    int equilibriumPoint(long long a[], int n) {
    long long totalSum = 0;
    long long leftSum = 0;

    // Calculate the total sum of the array
    for (int i = 0; i < n; i++) {
        totalSum += a[i];
    }

    for (int i = 0; i < n; i++) {
        // Subtract the current element from the total sum to get the right sum
        totalSum -= a[i];

        // Check if the left sum is equal to the right sum
        if (leftSum == totalSum) {
            return i + 1; // Equilibrium point found at index i
        }

        // Add the current element to the left sum
        leftSum += a[i];
    }

    return -1; // No equilibrium point found
}


};

//{ Driver Code Starts.


int main() {

    long long t;
    
    //taking testcases
    cin >> t;

    while (t--) {
        long long n;
        
        //taking input n
        cin >> n;
        long long a[n];

        //adding elements to the array
        for (long long i = 0; i < n; i++) {
            cin >> a[i];
        }
        
        Solution ob;

        //calling equilibriumPoint() function
        cout << ob.equilibriumPoint(a, n) << endl;
    }
    return 0;
}

// } Driver Code Ends