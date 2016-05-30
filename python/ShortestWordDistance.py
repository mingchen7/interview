'''
Created on Oct 18, 2015

@author: mingchen7
'''

class WordDistance(object):
    def __init__(self, words):
        """
        initialize your data structure here.
        :type words: List[str]
        """
        self.dic, self.l = {}, len(words)
        for i, w in enumerate(words):
            self.dic[w] = self.dic.get(w, []) + [i]        

    def shortest(self, word1, word2):
        """
        Adds a word into the data structure.
        :type word1: str
        :type word2: str
        :rtype: int
        """
        l1, l2 = self.dic[word1], self.dic[word2]
        i = j = 0
        res = self.l
        # O(m+n) time complexity
        while i < len(l1) and j < len(l2):
            res = min(res, abs(l1[i]-l2[j]))
            if l1[i] < l2[j]:
                i += 1
            else:
                j += 1
        return res    
    
words = ["practice", "makes", "perfect", "coding", "makes"]    
s = WordDistance(words)
print s.shortest("coding", "practice")

