# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def deepestLeavesSum(self, root: TreeNode) -> int:
        if root==None:
            return 0
        if root.left is None and root.right is None:
            return root.val
        dummy = TreeNode(-1)
        q = deque()
        q.append(root)
        q.append(dummy)
        sumval = 0
        endval = 0
        while(len(q)!=0):
            node = q.popleft()
            sumval+=node.val
            if node.left!=None:
                q.append(node.left)
            if node.right!=None:
                q.append(node.right)
            if q[0]==dummy:
                endval = sumval
                sumval=0
                q.popleft()
                if len(q)!=0:
                    q.append(dummy)
        return endval
                
                
                
            
        
