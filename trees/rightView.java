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
    int level = 0;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root==null)
        {
            return res;
        }
        int branch = 0;
        res = rightview(root,0,res);
        return res;
    }
    
    public List<Integer> rightview(TreeNode root,int branch,List<Integer> res)
    {
        if(root==null)
        {
            return res;
        }
        if(level<=branch)
        {
            res.add(root.val);
            level = level+1;
        }
        res = rightview(root.right,branch+1,res);
        res = rightview(root.left,branch+1,res);
        return res;
    }
}
