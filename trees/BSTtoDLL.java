//          5
//         /  \
//       3     8
//     /  \   / \
//    1   4  6   9
//    \       \
//     2      7


TreeNode prev_bst=null;
ListNode head=null;
public ListNode converttoDll(TreeNode root)
{
    BST2DLL(root);
    return head;
}

public void BST2DLL(TreeNode root)
{
  if(root==null)
  {
    return ;
  }
  BST2DLL(root.left);
  if(prev_bst==null)
  {
    head = root;
    root.left = prev_bst; 
  }
  else{
    root.left = prev_bst;
    prev_bst.right = root;
  }
  prev_bst = root;
  BST2DLL(root.right);
  
}
