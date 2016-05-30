class Solution(object):
    
#     def zigzagLevelOrder(self, root):
#         """
#         :type root: TreeNode
#         :rtype: List[List[int]]
#         """
#         ans, value = [], []
#         thisLevel, nextLevel = [root], []
#         direction = 0
#         while len(thisLevel):
#             while len(thisLevel):
#                 node = thisLevel.pop()
#                 value.append(node.val)
#                 if direction == 0: # left to right
#                     if node.left != None: nextLevel.append(node.left)
#                     if node.right != None: nextLevel.append(node.right)
#                     direction = 1
#                 else: # right to left
#                     if node.right != None: nextLevel.append(node.right)
#                     if node.left != None: nextLevel.append(node.left)
#                     direction = 0
#         
#         ans.append(value)
#         thisLevel = nextLevel
#         nextLevel = []
            
    def zigzagLevelOrder(self, root):
        ans, level, reverse = [], [root], False
        while root and level:
            if reverse:
                ans.append([node.val for node in level][::-1])
            else:
                ans.append([node.val for node in level])
            LRpair = [(node.left, node.right) for node in level]
            level = [leaf for LR in LRpair for leaf in LR if leaf]
            reverse = not reverse
        return ans



