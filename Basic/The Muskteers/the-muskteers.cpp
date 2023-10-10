//{ Driver Code Starts
//Initial Template for C++
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function Template for C++
class Solution{   
public:
    
   bool checkTogether(string s)
   {
       // Write your code here
       
       int n = s.length();
       int i=0;
       
       int count1 = 0;  // total zeroes in whole string
       int count2 = 0;  // zeroes that are together
       for(int i=0;i<n;i++)
       {
           if(s[i] == '0')
               count1++;
       }
       
       while(i != n)
       {
           while(i!=n && s[i] != '0')
               i++;
           
           int j = i;
           while(i!=n && s[i] == '0')
           {
               count2++;
               i++;
           }
           break;
       }
       
       
       if(count1 != 0 && count2 != 0 && count1 == count2)
           return true;
       return false;
   }// Write your code here
    
};

//{ Driver Code Starts.
int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        string str;
        cin >> str;
        Solution ob;
        bool ans = ob.checkTogether(str) ;
        
        if(ans){
            cout<< "YES" <<endl;
        }else{
            cout<<"NO"<<endl;
        }
    }
}
// } Driver Code Ends