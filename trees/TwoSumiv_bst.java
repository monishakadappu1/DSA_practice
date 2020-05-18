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
    HashSet<Integer> difval = new HashSet<Integer>();
    public boolean findTarget(TreeNode root, int k) {
        if(root==null)
        {
            return false;
        }
        Boolean res = searchbst(root,k);
        return res;
    }
    public boolean searchbst(TreeNode root, int k)
    {
        if(root==null)
        {
            return false;
        }
        int difk = (k-root.val);
        if(difval.contains(difk))
        {
            return true;
        }
        else{
            difval.add(root.val);
        }
        boolean left = searchbst(root.left,k);
        boolean right = searchbst(root.right,k);
        return (left||right);
    }
}
