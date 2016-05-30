'''
Created on Oct 18, 2015

@author: mingchen7
'''

class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: Set[str]
        :rtype: int
        """
        stack = wordList
        stack.append(beginWord)
        target = [endWord]
        tmp = []
        step = 1
        while stack:
            print step
            print target
            print stack 
            for word in stack:
                for tar_word in target:
                    if self.strComp(word,tar_word) == 1 and word not in tmp:                        
                        tmp.append(word)                                    
                        
            if len(tmp) == 0:
                return -1
            else:
                for word in tmp: stack.remove(word)
                target = tmp
                tmp = []
                step += 1            
        return step
            
        
    def strComp(self,str1,str2):
        diff = 0
        for i in range(len(str1)):
            if str1[i] != str2[i]:
                diff += 1
        return diff
    
    
s = Solution()
wordList = ["hot","dot","dog","lot","log"]
print s.ladderLength("hit","cog",wordList)

