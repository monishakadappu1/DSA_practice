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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)
        {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int count=0;
        while(!q.isEmpty())
        {
            int n =q.size();
            List<Integer> level = new ArrayList<Integer>();
            
            for(int i=0;i<n;i++)
            {
                TreeNode node=q.poll();
                if(node.left!=null)
                {
                    q.add(node.left);
                }
                if(node.right!=null)
                {
                    q.add(node.right);
                }
                if(count==0)
                {
                    level.add(node.val);
                }
                else if(count==1)
                {
                    level.add(0,node.val);
                }
            }
            res.add(level);
            count = count^1; 
        }
        return res;
    }
}
