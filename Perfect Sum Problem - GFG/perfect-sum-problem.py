#User function Template for python3
class Solution:
    def solve(self, ans, arr, summ, index, dp):
        # Base case (NOTE THE BASE CONDITION!!)
        if index<0:
            return summ==0  
        # Memoization condition
        if dp[summ][index]!=-1:
            return dp[summ][index]      
        # Recurrance relation
        pick=0
        if summ>=arr[index]:
            pick=self.solve(self.ans, arr, summ-arr[index], index-1, dp)
        notPick=self.solve(self.ans, arr, summ, index-1, dp)
        dp[summ][index] = (pick+notPick)%(10**9+7)
        return dp[summ][index]
    
	def perfectSum(self, arr, n, summ):
	    self.ans=0
	    # here there are 2 vars index ans summ
	    # summ==row and index==col 
	    dp=[[-1 for i in range(n+1)]for j in range(summ+1)]
	    return self.solve(self.ans, arr, summ, len(arr)-1, dp)

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