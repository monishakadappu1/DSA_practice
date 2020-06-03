class Solution {
    
    class Pair{
        int value;
        int indx;
        public Pair(int val, int x)
        {
            value = val;
            indx = x;
        }
    }
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        if(nums.length==0)
        {
            return result;
        }
        Stack<Pair> st = new Stack<Pair>();
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<n*2;i++)
        {
            int j = i%n;
            if(st.size()==0)
            {
                Pair p = new Pair(nums[j],i);
                st.push(p);
            }
            else{
                Pair q = new Pair(nums[j],i);
                while(!st.empty() && st.peek().value<q.value)
                {
                    Pair p = st.pop();
                    map.put(p.indx,q.value);
                }
                st.push(q);
            }
        }
        for(int i=0;i<n;i++)
        {
            if(map.containsKey(i))
            {
                result[i] = map.get(i);
            }
            else{
                result[i] = -1;
            }
        }
        return result;
    }
}
