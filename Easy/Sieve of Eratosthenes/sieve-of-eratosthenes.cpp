//{ Driver Code Starts
#include<bits/stdc++.h> 
using namespace std; 

// } Driver Code Ends
//User function Template for C++
class Solution
{

public:
    vector<int> sieveOfEratosthenes(int N)
    {
        // Write Your Code here
        bool p[N+1];
        vector<int>v;
        p[0]=false;p[1]=false;
        for(int i=2;i<=N;i++)
            p[i] = N;
        for(int i=2;i*i<=N;i++)
            if(p[i]==true)
                for(int j=2*i;j<=N;j=j+i)
                    p[j]=false;
        for(int i=2;i<=N;i++)
            if(p[i]==true)
                v.push_back(i);
        return v;
    }
};



//{ Driver Code Starts.
int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int N;
        cin>>N;
        Solution ob;
        vector<int> primes  = ob.sieveOfEratosthenes(N);
        for(auto prime : primes) {
            cout<< prime <<" ";
        }
        cout<<endl;
    }
    return 0;
}
// } Driver Code Ends