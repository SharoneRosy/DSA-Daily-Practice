class Solution:
    def isPalindrome(self, x: int) -> bool:
        stringX = str(x)
		#reverse the string by the last index from backwards to forwards
        reverseX = stringX[::-1]
		#if the forward version of the string equals the reversed then it's a palindrome
        if stringX == reverseX:
            return(True)
        return(False)
        
       