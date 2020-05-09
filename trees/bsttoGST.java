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
    int tv;
    Solution(){
        this.tv = 0;
    }
    public TreeNode bstToGst(TreeNode root) {
        if(root == null)
        {
            tv = tv+0;
            return null;
        }
        bstToGst(root.right);
        tv = tv + root.val;
        root.val = tv;
        bstToGst(root.left);
        return root;
    }
}
