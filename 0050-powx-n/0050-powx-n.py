class Solution:
    def myPow(self, x: float, n: int) -> float:
         
        if n>=0:
           return self.helper(x,n)
        else:
            return 1/self.helper(x,-n)
    def helper(self,x,n):
        if n==0:
            return 1
        t=self.helper(x,n//2)
        t=t*t
        if (n%2==0):
            return t
        else:
            return t*x