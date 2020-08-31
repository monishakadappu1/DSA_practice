# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        dummy = ListNode(0)
        nums = dummy
        carry = 0
        while(l1!=None or l2!=None):
            if(l1!=None and l2!=None):
                num = l1.val + l2.val
                l1 = l1.next
                l2 = l2.next
            elif(l1!=None):
                num = l1.val
                l1 = l1.next
            elif(l2!=None):
                num = l2.val
                l2 = l2.next 
            num = num+carry
            if num<=9:
                numnode = ListNode(num)
                carry = 0
            elif num>9:
                rem = num %10
                carry = int(num/10)
                numnode = ListNode(rem)
                
            nums.next = numnode
            nums = numnode
        while(carry>0):
            rem = carry %10
            numnode = ListNode(rem)
            nums.next = numnode
            nums = numnode
            carry = int(carry/10)
        return dummy.next
            
                    
        
