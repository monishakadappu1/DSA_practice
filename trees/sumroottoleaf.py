# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.listsum = []
        
    def sumNumbers(self, root: TreeNode) -> int:
        if root is None:
            return 0
        if root.left is None and root.right is None:
            return root.val
        self.sumleaves(root,"")
        total = 0
        for sumroot in self.listsum:
            total = total + int(sumroot)
        return total
    
    def sumleaves(self,root,pathsum):
        if root is None:
            return
        if root.left is None and root.right is None:
            pathsum = pathsum + str(root.val)
            self.listsum.append(pathsum)
            return
        pathsum = pathsum + str(root.val)
        self.sumleaves(root.left,pathsum)
        self.sumleaves(root.right, pathsum)
        return
        
