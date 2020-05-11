/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
        {
            return null;
        }
        if(root==p || root == q)
        {
            return root;
        }
        TreeNode templeft = lowestCommonAncestor(root.left,p,q);
        TreeNode tempright = lowestCommonAncestor(root.right,p,q);
        if(templeft!=null && tempright!=null)
        {
            return root;
        }
        if(templeft!=null && tempright==null)
        {
            return templeft;
        }
        if(tempright!=null && templeft==null)
        {
            return tempright;
        }
        else{
            return null;
        }
    }
}
