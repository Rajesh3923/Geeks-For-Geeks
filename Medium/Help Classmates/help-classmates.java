//{ Driver Code Starts
//Initial Template for Java


import java.util.*; 
import java.io.*; 

class GFG 
{ 
	public static void main (String[] args) { 
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
            int array[] = new int[n];
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }

            Solution ob = new Solution();

            int ans[] = ob.help_classmate(array,n);

           	for (int i=0; i<n; i++) 
                System.out.print(ans[i]+" "); 
            System.out.println();
            t--;
        }
	} 
} 


// } Driver Code Ends


//User function Template for Java

class Solution {
	public static int[] help_classmate(int arr[], int n) 
	{ 
	    Stack<Integer>st=new Stack<>();
	    int a[]=new int[arr.length];
	    for(int i=0;i<n;i++){
	        a[i]=-1;
	    }
	    for(int i=0;i<arr.length;i++){
	        while(!st.isEmpty()&&arr[st.peek()]>arr[i]){
	           // int index=i;
	            a[st.peek()]=arr[i];
	            st.pop();
	            
	            
	        }
	        st.push(i);
	        
	    }return a;
	} 
}
