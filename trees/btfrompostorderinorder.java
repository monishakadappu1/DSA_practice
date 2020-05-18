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
    int pindex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        if(n==0)
        {
            return null;
        }
        if(n==1)
        {
            return new TreeNode(inorder[0]);
        }
        pindex = n-1;
        TreeNode root = buildUtil(inorder,postorder,0,n-1);
        return root;
    }
     public TreeNode buildUtil(int[] inorder,int[] postorder,int istart,int iend)
     {
         if(istart>iend)
         {
             return null;
         }
         TreeNode root = new TreeNode(postorder[pindex]);
         pindex--;
         if(istart==iend)
         {
             return root;
         }
         int iindex = search(istart,iend,inorder,root.val);
         root.right = buildUtil(inorder,postorder,iindex+1,iend);
         root.left = buildUtil(inorder,postorder,istart,iindex-1);
         return root;
     }
    public int search(int start,int end,int[] inorder,int val)
    {
        for(int i=start;i<=end;i++)
        {
            if(inorder[i]==val)
            {
                return i;
            }
        }
        return -1;
    }
}
