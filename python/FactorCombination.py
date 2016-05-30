'''
Created on Oct 17, 2015

@author: mingchen7
'''

class Solution(object):        
    def getFactors(self, n):
        res = []
        self.dfs(self.factors(n)[1:-1], n, 0, [], res)
        return res
    
    def dfs(self, nums, n, index, path, res):
        tmp = reduce(lambda x,y:x*y, path, 1)
        if tmp > n:
            return  # backtracking
        if tmp == n and path:
            res.append(path)
            return  # backtracking 
        for i in xrange(index, len(nums)):
            self.dfs(nums, n, i, path+[nums[i]], res)
    
    def factors(self, n):
        res = []
        for i in xrange(1, n+1):
            if n % i == 0:
                res.append(i)
        return res
    
s = Solution()
n = 24
ans = s.getFactors(n)
print ans
