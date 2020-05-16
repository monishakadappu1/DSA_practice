/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode[] nodes = getNodes(head);
        ListNode prev = nodes[0];
        ListNode slow = nodes[1];
        if (prev == null) {
            return new TreeNode(head.val);
        }
        
        prev.next = null;
        TreeNode curr = new TreeNode (slow.val);
        curr.left = sortedListToBST(head);
        curr.right = sortedListToBST(slow.next);
        return curr;     
        
    }
    private ListNode[] getNodes(ListNode node) {
        ListNode prev = null;
        ListNode slow = node;
        ListNode fast = node;
        
        while (fast != null && fast.next != null) {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        
        if (prev == null) {
            return new ListNode[] {null, null};
        }
        
        return new ListNode[] {prev, slow};
    }
}
