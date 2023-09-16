#User function Template for python3

class Solution:
    #Function to count the number of ways in which frog can reach the top.
 def countWays(self,n):
    dp=[1,2,4,0]
    for i in range(4,n+1):
        dp[-1]=(dp[-2]+dp[-3]+dp[-4])%(10**9+7)
        dp[-4]=dp[-3]
        dp[-3]=dp[-2]
        dp[-2]=dp[-1]
    return dp[-1] if n>3 else dp[n-1]

#{ 
 # Driver Code Starts
#Initial Template for Python 3
import atexit
import io
import sys
sys.setrecursionlimit(10**6)
# Contributed by : Nagendra Jha

if __name__ == '__main__':
    test_cases = int(input())
    for cases in range(test_cases):
        m = int(input())
        ob=Solution()
        print(ob.countWays(m))
# } Driver Code Ends