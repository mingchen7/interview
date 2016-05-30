'''
Created on Oct 17, 2015

@author: mingchen7
'''

import math

class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        low, high = 0, n-1
        if n == 1: return nums[0]
        sum = self.DivideConq(nums,low,high)
        return sum
    
    def DivideConq(self,nums, low, high):
        if low < high:
            s = self.DivideConq(nums,low,int(math.floor((low+high)/2)))
            s = max(s,self.DivideConq(nums,int(math.floor((low+high)/2)+1),high))
            s = max(s, self.FindMax(nums,low,high))
            return s
        else: # low == high
            return nums[low]
    
    def FindMax(self,nums,low,high):
        mid = int(math.floor((low+high)/2))
        sumL, sumR = [],[]
        for i in range(0,mid-low+1):
            sumL[i] = sum(nums[(mid-i):(mid+1)])
        for i in range(0,high-mid+1):
            sumR[i] = sum(nums[mid+1:mid+i+2])
        return max(sumL) + max(sumR)
    
s = Solution()
nums = [-2,1,-3,4,-1,2,1,-5,4] 
print s.maxSubArray(nums)
        
        