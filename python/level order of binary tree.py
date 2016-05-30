def levelOrder(self, root):
        outputList = []
        
        # get the height of tree
        height = self.getHeight(root)
        print(height)
        
        # get the results for every level
        for i in range(height):
            lvlList = self.appendGivenLevel(root,i)
            outputList.append(lvlList)
            
        return outputList
        
    def getHeight(root):
        if(root == None):
            return 0
            
        leftHeight = self.getHeight(root.left)
        rightHeight = self.getHeight(root.right)
        
        if(leftHeight > rightHeight):
            return leftHeight + 1
        else:
            return rightHeight + 1

    def appendGivenLevel(root, level):
        # levelList = []    
        if(root == None):
            return
        elif(level == 1):
            levelList.append(root.val)
            print root.val
        else:
            leftList = self.appendGivenLevel(root.left,level-1)
            rightList = self.appendGivenLevel(root.right,level-1)
            # levellist.extend(leftList,rightList)
        
        # return levelList
        
        
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        