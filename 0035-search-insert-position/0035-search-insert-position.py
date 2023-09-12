class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        


        s=0
        e=len(nums) -1
        while s<=e:
            m=(e+s)//2
            if (nums[m]==target):
                return m
            elif (nums[m]>target):
                e=m-1
            else:
                s=m+1
        return s