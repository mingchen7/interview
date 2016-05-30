'''
Created on Oct 16, 2015

@author: mingchen7
'''

class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        array = []
        reverse_array = []
        leng = len(nums)
        cumProd = 1
        reverse_cumProd = 1
        ans = []
        for i in range(leng):
            # compute values for array
            if i == 0:
                array.append(1)
            else:
                cumProd = cumProd * nums[i-1]
                array.append(cumProd)
                            
            # compute values for reverse array
            if i == 0: 
                reverse_array.append(1)
            else:
                reverse_cumProd = reverse_cumProd*nums[leng-1-(i-1)]
                reverse_array.append(reverse_cumProd)
                                
        for i in range(leng):
            ans.append(array[i] * reverse_array[leng-1-i])
        
        print array, reverse_array
        return ans
                
            
            
s = Solution()
nums = [1,2,3,4,5,6,7,8,9,10]
ans = s.productExceptSelf(nums)
print ans