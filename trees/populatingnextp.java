/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null)
        {
            return null;
        }
        if(root.left!=null)
        {
            if(root.right!=null)
            {
                root.left.next = root.right;
            }
            else{
                root.left.next = findnext(root.next);
            }
        }
        if(root.right!=null && root.next!=null)
        {
            root.right.next=findnext(root.next);
        }
        connect(root.right);
        connect(root.left);
        return root;
    }
    public Node findnext(Node root)
    {
      while(root!=null)
        {
            if(root.left!=null || root.right!=null)
            {
                return (root.left!=null?root.left:root.right);
            }
            root=root.next;
        }
        return null;
    }
        
}
