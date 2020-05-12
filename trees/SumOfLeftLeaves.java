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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        int sum = sumLeaves(root,0);
        return sum;        
    }
    public int sumLeaves(TreeNode root,int left)
    {
        if(root == null)
        {
            return 0;
        }
        if(root.left==null && root.right==null && left==1)
        {
            return root.val;
        }
        int insum = 0;
        int leftsum = sumLeaves(root.left,1);
        int rightsum = sumLeaves(root.right,0);
        return (leftsum+rightsum);
    }
}
