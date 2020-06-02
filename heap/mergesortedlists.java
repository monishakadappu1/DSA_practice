/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public class listCompare implements Comparator<ListNode>{
        public int compare(ListNode A, ListNode B)
        {
            return (A.val-B.val);
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
        {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length,new listCompare());
        for(int i=0;i<lists.length;i++)
        {
            if(lists[i]!=null)
            {
                pq.add(lists[i]);
            }            
        }
        head.next = pq.peek();
        head = head.next;
        while(pq.size()!=0)
        {
            // System.out.println("size");
            // System.out.println(pq.size());
            // System.out.println("peek");
            // System.out.println(pq.peek().val);
            ListNode temp = pq.poll();
            // System.out.println("poll");
            // System.out.println(pq.peek().val);
            if(temp.next!=null)
            {
                pq.add(temp.next);
            }            
            head.next = pq.peek();
            head=head.next;
        }
        return dummy.next;
    }
}
