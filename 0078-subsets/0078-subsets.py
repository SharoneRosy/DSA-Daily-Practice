class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        l=[]
        x=[]
        n=len(nums)
        def helper(nums,i,l):
            if i<0:
                x.append(l)
                return 0
            helper(nums,i-1,l+[nums[i]])     #including the elemnt in the subset
            helper(nums,i-1,l)              #excluding the element in the subset
        helper(nums,n-1,l)
        return x
    
            
            
       