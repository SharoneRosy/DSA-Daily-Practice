#User function Template for python3

class Solution:
	def AllPrimeFactors(self, n):
	    s=[]
		while(n%2==0):
		    s.append(2)
		    n=n//2
		while(n%3==0):
		    s.append(3)
            n=n//3
        for i in range(5,n,6):
            while(n%i==0):
                s.append(i)
                n=n//i
            while(n%(i+2)==0):
                s.append(i+2)
                n=n//(i+2)
        if n>3:
            s.append(n)
        a=set(s)
        ans=list(a)
        ans.sort()
        return ans

#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
	T=int(input())
	for i in range(T):
		N = int(input())
		ob = Solution()
		ans = ob.AllPrimeFactors(N)
		for _ in ans:
			print(_, end = " ")
		print()
# } Driver Code Ends