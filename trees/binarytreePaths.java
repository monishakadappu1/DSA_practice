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
    List<String> res = new ArrayList<String>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null)
        {
            return res;
        }
        bstsearch(root,"");
        return res;
    }
    
    public void bstsearch(TreeNode root,String path)
    {
        if(root==null)
        {
            return;
        }
        if(root.left==null && root.right==null)
        {
            if(path=="")
            {
                path = Integer.toString(root.val);
            }
            else{
                path= path + "->" + Integer.toString(root.val);
            }
            res.add(path);
            return;
        }
        if(path=="")
        {
            path = Integer.toString(root.val);
        }
        else{
            path= path + "->" + Integer.toString(root.val);
        }
        bstsearch(root.left,path);
        bstsearch(root.right,path);
        return;
        
    }
}
