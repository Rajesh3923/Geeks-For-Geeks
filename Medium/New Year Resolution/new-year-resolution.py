
from typing import List

class Solution:
    def isPossible(self, N: int, coins: List[int]) -> bool:
        def utils(idx, N, coins, sum):
            if sum != 0 and (sum % 2024 == 0 or sum % 20 == 0 or sum % 24 == 0):
                return True
            if idx == N:
                return False
            return utils(idx + 1, N, coins, sum + coins[idx]) or utils(idx + 1, N, coins, sum)

        return utils(0, N, coins, 0)    



#{ 
 # Driver Code Starts

class IntArray:
    def __init__(self) -> None:
        pass
    def Input(self,n):
        arr=[int(i) for i in input().strip().split()]#array input
        return arr
    def Print(self,arr):
        for i in arr:
            print(i,end=" ")
        print()


if __name__=="__main__":
    t = int(input())
    for _ in range(t):
        
        N = int(input())
        
        
        coins=IntArray().Input(N)
        
        obj = Solution()
        res = obj.isPossible(N, coins)
        
        result_val = 1 if res else 0
        print(result_val)

# } Driver Code Ends