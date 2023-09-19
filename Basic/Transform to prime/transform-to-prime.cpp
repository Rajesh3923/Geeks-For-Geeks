//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;
#define ll long long
long long minNumber(long long arr[],long long N);

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    ll t;
    cin>>t;
    while(t--){
    ll n;
    cin>>n;
    ll arr[n];
    for(ll i=0;i<n;i++)
        cin>>arr[i];
    cout << minNumber(arr, n)<<endl;
    }
    return 0;
}
// } Driver Code Ends

bool isPrime(long long n) {
    if (n <= 1) {
        return false;
    }
    if (n == 2) {
        return true;
    }
    if (n % 2 == 0) {
        return false;
    }

    for (long long i = 3; i * i <= n; i += 2) {
        if (n % i == 0) {
            return false;
        }
    }

    return true;
}

long long minNumber(long long arr[], long long N) {
    long long sum = 0;
    for (long long i = 0; i < N; i++) {
        sum += arr[i];
    }

    if (isPrime(sum)) {
        return 0;
    }

    for (long long i = 1; ; i++) {
        if (isPrime(sum + i)) {
            return i;
        }
    }

    return -1; // Return -1 if no prime is found
}
