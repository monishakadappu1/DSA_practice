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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = buildbst(preorder,0,preorder.length);
        return root;
    }
    
    public TreeNode buildbst(int[] preorder,int start, int end)
    {
        if(end<start || preorder.length==0)
        {
            return null;
        }
        TreeNode root = new TreeNode(preorder[start]);
        int i = start+1;
        while(i<end && preorder[i]>root.val)
        {
            i++;
        }
        int starti = i;
        int  j = start+1;
        while(j<end && preorder[j]<root.val)
        {
            j++;
        }
        int endj = j;
        if(i<end)
        {
            root.left = buildbst(preorder,starti,endj);
        }
        if(endj<end)
        {
            root.right = buildbst(preorder,endj,end);
        }
        return root;
    }
}
