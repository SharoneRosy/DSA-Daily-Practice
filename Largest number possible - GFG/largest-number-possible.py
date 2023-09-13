#User function Template for python3

class Solution:
    def findLargest(self, n, s):
        if s==0 and n==1:
            return 0
        if s==0 or 9*n<s:
            return -1
        var=9
        res=''
        for i in range(N):
            for j in range(9,-1,-1):
                if s>=j:
                    res+=str(j)
                    s-=j
                    break
        return res


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    t = int(input())
    for _ in range(t):
        N, S = [int(x) for x in input().split()]
        
        ob = Solution()
        print(ob.findLargest(N, S))
# } Driver Code Ends