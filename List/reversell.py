# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        if head==None or head.next==None:
            return head
        curnode = head.next 
        prevnode = head 
        head.next=None
        while(curnode!=None):  
            nextnode = curnode.next 
            curnode.next = prevnode 
            prevnode = curnode  
            curnode = nextnode 
        return prevnode 
        
