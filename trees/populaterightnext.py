#using dynamic space 
"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

class Solution:
    def __init__(self):
        self.hashlevel = {}
        
    def connect(self, root: 'Node') -> 'Node':
        if root is None:
            return None
        level = 0
        return self.connectnext(root,level)
    
    def connectnext(self,root,level):
        if root is None:
            return None
        if level in self.hashlevel:
            prevroot = self.hashlevel[level]
            prevroot.next = root
            self.hashlevel[level]=root
        else:
            self.hashlevel[level]=root
        self.connectnext(root.left,level+1)
        self.connectnext(root.right,level+1)
        return root

    
#using constant space ,best solution
"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if root is None:
            return None
        return self.connectNext(root,None)
    
    def connectNext(self,root,nextroot):
        if root is None:
            return None
        root.next = nextroot
        self.connectNext(root.left,root.right)
        self.connectNext(root.right,root.next.left if root.next else None)
        return root
        
