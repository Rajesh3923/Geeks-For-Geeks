#User function Template for python3
from functools import lru_cache
import sys
sys.setrecursionlimit(10**6)
class Solution:
	def perfectSum(self, arr, n, sum):
		# code here
		@lru_cache(None)
		def solve(i,t):
		    if t==0:
		        return 1
		    if i==n or arr[i]>t:
		        return 0
		    return (solve(i+1,t-arr[i])%m+solve(i+1,t)%m)%m
		m=10**9+7
		arr.sort()
        return solve(0,sum)

#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
	T=int(input())
	for i in range(T):
		n,sum = input().split()
		n,sum = int(n),int(sum)
		arr = [int(x) for x in input().split()]
		ob = Solution()
		ans = ob.perfectSum(arr,n,sum)
		print(ans)

# } Driver Code Ends