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
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode dummy = new TreeNode(-1);
        int total = 0;
        queue.add(root);   //1
        queue.add(dummy);       //-1
        while(queue.size()!=0)
        {
            TreeNode temp = queue.remove();  //7 8
            total = total+temp.val;  //15
            if(temp.left!=null)   
            {
                queue.add(temp.left);    //8 -1
            }
            if(temp.right!=null)
            {
                queue.add(temp.right);   //3  // -1 7 8
            }
            if(queue.peek()==dummy)   //-1
            {
                dummy = queue.remove();  
                if(queue.size()!=0)
                {
                    total = 0;      //t=0 //t=0
                    queue.add(dummy);   // 2 3 -1 // 4 5 6 -1
                }
            }
        }
        return total;
    }
}
