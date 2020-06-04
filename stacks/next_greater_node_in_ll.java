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
    class Pair{
        int indx;
        int nodeval;
        public Pair(int count,int head)
        {
            indx = count;
            nodeval = head;
        }
    }
    public int[] nextLargerNodes(ListNode head) {
        if(head==null)
        {
            return new int[0];
        }
        Stack<Pair> st = new Stack<Pair>();
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int count = 0;
        ListNode dummy = head;
        while(dummy!=null)
        {
            if(st.empty())
            {
                Pair p =new Pair(count,dummy.val);
                st.push(p);
                dummy = dummy.next;
                count++;
            }
            else{
                ListNode cur = dummy;
                while(!st.empty() && cur.val>st.peek().nodeval)
                {
                    Pair prev = st.pop();
                    map.put(prev.indx,cur.val);
                }
                Pair c = new Pair(count,cur.val);
                st.push(c);
                dummy = dummy.next;
                count++;
            }
        }
        int res[] = new int[count];
        for(int i=0;i<count;i++)
        {
            if(map.containsKey(i))
            {
                res[i] = map.get(i);
            }
        }
        return res;
        
    }
}
