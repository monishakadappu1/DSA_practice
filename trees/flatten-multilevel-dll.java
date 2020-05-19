/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head==null)
        {
            return null;
        }
        if(head.child!=null)
        {
            Node last = head.next;
            head.child.prev = head;
            head.next = merge(head.child,last);
            head.child = null;
        }
        flatten(head.next);
        return head;
    }
    
    public Node merge(Node child,Node last)
    {
        if(last==null)
        {
            return child;
        }
        Node head = child;
        while(child.next!=null)
        {
            child = child.next;
        }
        child.next = last;
        last.prev = child;
        return head;
    }
}
