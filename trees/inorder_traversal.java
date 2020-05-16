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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res= new ArrayList<Integer>();
        if(root==null)
        {
            return res;
        }
        Stack<TreeNode> track = new Stack<TreeNode>();
        while(root!=null || track.size()>0)
        {
            while(root!=null)
            {
                track.push(root);
                root=root.left;
            }
            
            TreeNode cur = track.pop();               
            root=cur;
            res.add(root.val);               
            root = root.right;
            }          
            
        return res;
        
    }
}
