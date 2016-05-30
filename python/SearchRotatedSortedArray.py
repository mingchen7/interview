'''
Created on Oct 18, 2015

@author: mingchen7
'''

import math

class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if len(nums) == 1 and nums[0] == target:
            return 0
        else:        
            imin,imax = 0, len(nums)-1
            if nums[imin] > nums[imax]: #rotated
                return self.SearchRotated(nums,target,imin,imax)
            else:
                return self.BinarySearch(nums, target, imin, imax)
        
        return -1
    
    def SearchRotated(self,nums,target,imin,imax):
        if imax-imin+1 == 2:
            if nums[imin] == target: return imin
            elif nums[imax] == target: return imax
            else: return -1
        
        mid = int(math.floor((imax+imin)/2))
        if nums[imin] > nums[mid]: # left rotated
            i1 = self.SearchRotated(nums,target,imin,mid)
            i2 = self.BinarySearch(nums,target,mid+1,imax)
        elif nums[mid+1] > nums[imax]: # right rotated
            i1 = self.BinarySearch(nums,target,imin,mid)
            i2 = self.SearchRotated(nums,target,mid+1,imax)
        else:
            i1 = self.BinarySearch(nums, target, imin, mid)
            i2 = self.BinarySearch(nums, target, mid+1, imax)
            
        if i1 != -1: return i1
        elif i2 != -1: return i2
        else: return -1
            
    def BinarySearch(self,nums,target,imin,imax):        
        while imin<=imax:
            imid = int(math.floor((imax+imin)/2))
            if nums[imid] == target:
                return imid
            elif nums[imid] < target:
                imin = imid+1
            else:
                imax = imid-1
            
        return -1
    
s = Solution()
# nums = [8,9,10,0,1,2,3,4,5,6,7]
nums = [1,3]
print s.search(nums,1)

