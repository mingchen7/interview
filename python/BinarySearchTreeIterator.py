'''
Created on Oct 17, 2015

@author: mingchen7
'''

class BSTIterator(object):
    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.__curr=root
        self.__trace=[]
        if root!=None:
            while self.__curr.left!=None:
                self.__trace.append(self.__curr)
                self.__curr=self.__curr.left


    def hasNext(self):
        """
        :rtype: bool
        """
        return self.__curr!=None 


    def next(self):
        """
        :rtype: int
        """
        curr=self.__curr
        if curr.right!=None:
            self.__trace.append(curr)
            temp=curr.right
            while temp.left!=None:
                self.__trace.append(temp)
                temp=temp.left
            self.__curr=temp
        else:
            temp=curr
            while self.__trace and self.__trace[-1].right==temp:
                temp=self.__trace.pop()
            if self.__trace:
                temp=self.__trace.pop()
            else:
                temp=None
            self.__curr=temp
        return curr.val

# Your BSTIterator will be called like this:
# i, v = BSTIterator(root), []
# while i.hasNext(): v.append(i.next())