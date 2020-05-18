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
    int pindex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0||inorder.length==0)
        {
            return null;
        }
        if(preorder.length==1)
        {
            return new TreeNode(preorder[0]);
        }
        int n = preorder.length;
        TreeNode root = buildUtil(preorder,inorder,0,n-1);
        return root;
    }
    public TreeNode buildUtil(int[] preorder,int[] inorder,int istart,int iend)
    {
        if(istart>iend)
        {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pindex]);
        pindex++;
        if(istart==iend)
        {
            return root;
        }
        int iindex = search(istart,iend,inorder,root.val);
        root.left = buildUtil(preorder,inorder,istart,iindex-1);
        root.right = buildUtil(preorder,inorder,iindex+1,iend);
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
