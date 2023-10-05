
def findSumOfDigits(n):
    
    fact=1
    for i in range(1,n+1):
        fact*=i
    sum=0
    while fact>0:
        sum+=fact%10
        fact=fact//10
    print(sum)


#{ 
 # Driver Code Starts

if __name__ == "__main__":
    t=int(input())
    for i in range(t):
        n=int(input())
        findSumOfDigits(n)
# } Driver Code Ends