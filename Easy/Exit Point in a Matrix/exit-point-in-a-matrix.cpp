//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    int check(int i,int j,int n,int m){
        if(i<0 or i>=n) return 1;
        if(j<0 or j>=m) return 1;
        return 0;
    }
    vector<int> FindExitPoint(int n, int m, vector<vector<int>>& matrix) {
        vector<int> dx={0,1,0,-1};
        vector<int> dy={1,0,-1,0};
        int x=0,y=0;
        int c=0;
        while(true){
            if(matrix[x][y]==1){
                matrix[x][y]=0;
                c++;
                c%=4;
            }
            x+=dx[c];
            y+=dy[c];
            if(check(x,y,n,m)) return {x-dx[c],y-dy[c]};
        }
    }
};


//{ Driver Code Starts.
int main() {
    int tc;
    cin >> tc;
    while (tc--) {
        int n, m;
        cin >> n >> m;
        vector<vector<int>> matrix(n, vector<int>(m, 0));
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                cin >> matrix[i][j];
        Solution obj;
        vector<int> ans = obj.FindExitPoint(n, m, matrix);
        for (auto i : ans)
            cout << i << " ";
        cout << "\n";
    }
    return 0;
}
// } Driver Code Ends