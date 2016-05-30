'''
Created on Oct 17, 2015

@author: mingchen7
'''

import copy

class Solution(object):
    
#     def permute(self, nums):
#         """
#         :type nums: List[int]
#         :rtype: List[List[int]]
#         """
#         ans = []
#         if len(nums) == 1:
#             return [nums]
#     
#         if len(nums) == 2: 
#             return [nums,[nums[1],nums[0]]]
#         
#         for num in nums:
#             newNums = copy.deepcopy(nums) 
#             newNums.remove(num)
#             tmpList = self.permute(newNums)
#             for i in range(len(tmpList)):
#                 tmpList[i].insert(0,num)
#                 ans.append(tmpList[i])
#         
#         return ans
    
    
#     def permute(self, nums):
#         ans = [nums]
#         for i in xrange(1, len(nums)):
#             m = len(ans)
#             for k in xrange(m):
#                 for j in xrange(i):
#                     ans.append(ans[k][:])
#                     ans[-1][j], ans[-1][i] = ans[-1][i], ans[-1][j]
#         return ans
    
    def permute(self,nums):
        stack = [([])]
        res = []
    
        while stack:
            comb = stack.pop()
            if len(comb) == len(nums):
                res.append(comb)
                continue
            for n in range(0, len(nums)):
                if nums[n] not in comb:
                    stack.append((comb + [nums[n]]))
        return res
    
    
s = Solution()
nums = [1,2,3]
ans = s.permute(nums)
for item in ans:
    print item