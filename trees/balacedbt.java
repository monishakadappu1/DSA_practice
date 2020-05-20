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
    public boolean isBalanced(TreeNode root) {
        if(root==null)
        {
            return true;
        }
        boolean leftstatus = isBalanced(root.left);
        boolean rightstatus = isBalanced(root.right);
        int left = checkheight(root.left);
        int right = checkheight(root.right);
        int diff = Math.abs(right-left);
        
        return (leftstatus && rightstatus && (diff<=1));
    }
    
    public int checkheight(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int left = checkheight(root.left);
        int right = checkheight(root.right);
        return 1 + Math.max(left,right);
    }
}
