class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        if(nums1.length==0 || nums2.length==0)
        {
            return res;
        }
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        Stack<Integer> great = new Stack<Integer>();
        great.push(nums2[0]);
        for(int i=1;i<nums2.length;i++)
        {
            int cur = nums2[i];
            while(great.size()>0 && great.peek()<cur)
            {
                int prev = great.pop();
                map.put(prev,cur);
            }
            great.push(cur);
        }
        
        for(int i=0;i<nums1.length;i++)
        {
            if(map.containsKey(nums1[i]))
            {
                res[i] = map.get(nums1[i]);
            }
            else{
                res[i]=-1;
            }
        }
        return res;
    }
}
