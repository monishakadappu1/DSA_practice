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
    int path=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        diameter(root);
        return path;
    }
    public int diameter(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int left=diameter(root.left);
        int right=diameter(root.right);
        path = Math.max(left+right,path);
        return (Math.max(left,right)+1);
    }
}
