'''
Created on Oct 18, 2015

@author: mingchen7
'''

class Solution(object):
#     def maxProduct(self, nums):
#         """
#         :type nums: List[int]
#         :rtype: int
#         """
#         
#         max_ending = max_sofar = max_ending_tmp = nums[0]
#         if nums[0] < 0: neg1,neg2 = 1, 0
#         else: neg1 = neg2 = 0
#         for x in nums[1:]:
#             if x < 0: 
#                 if neg1 == 1 and neg2 != 1: neg2 = 1
#                 elif neg1 == 1 and neg2 == 1: neg1 = neg2 = 0
#                 elif neg1 == 0 and neg2 ==0: neg1 = 1
#                 
#             max_ending = max(x,max_ending*x)
#             if neg1 ==1 and neg2 != 1:
#                 max_ending_tmp = max_sofar*x
#                 max_sofar = max(max_ending,max_sofar)
#             elif neg1==1 and neg2==1:
#                 max_sofar = max(max_ending,max_sofar,max_ending_tmp*x)
#             else:
#                 max_sofar = max(max_ending,max_sofar)
#             
#         return max_sofar
        
    def maxProduct(self, nums):
        if not nums:
            return 
        locMin = locMax = gloMax = nums[0]
        for i in xrange(1, len(nums)):
            tmp = locMin
            locMin = min(locMin*nums[i], nums[i], locMax*nums[i])
            locMax = max(tmp*nums[i], nums[i], locMax*nums[i])
            gloMax = max(gloMax, locMax)
        return gloMax   
    
s = Solution()
array = [-2,3,-4,-5]
print s.maxProduct(array)
        
