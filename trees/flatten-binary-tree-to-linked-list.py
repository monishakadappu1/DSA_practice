# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if root is None:
            return None
        prev = None
        root = self.flattenroot(root,prev)
        return
    
    def flattenroot(self, root ,prev):
        if root is None:
            return prev
        if prev is not None:
            prev.right = root
            prev.left = None
        prev=root
        rootleft = root.left
        rootright = root.right
        prev = self.flattenroot(rootleft,prev)
        prev = self.flattenroot(rootright,prev)
        return prev
    
