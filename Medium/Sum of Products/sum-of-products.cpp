//{ Driver Code Starts
// Initial template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function template for C++

class Solution {
  public:
    long long pairAndSum(int n, long long arr[]) {
        long long ans=0;
        for(int i=0;i<32;i++){
            long long int c=0;
            long long int t=1<<i;
            for(int j=0;j<n;j++){
                
                if(t&arr[j]){
                    c++;      //no.of elemenets that has 1's on same bit
                }
            
                
            }
            ans+=(c*(c-1)/2)*(t);    //nc2 and converting into decimal also
        }
        return(ans);
    }



};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int N;
        cin >> N;
        long long Arr[N];
        for (int i = 0; i < N; i++) {
            cin >> Arr[i];
        }
        Solution ob;
        cout << ob.pairAndSum(N, Arr) << endl;
    }
    return 0;
}
// } Driver Code Ends