class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map  = new HashMap<Integer,Integer>();
        int maxlength = 0;
        int count = 0;
        map.put(count,-1);
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                count+=-1;
            }
            else{
                count+=1;
            }
            if(map.containsKey(count))
            {
                maxlength = Math.max(maxlength,i-map.get(count));
            }
            else{
                map.put(count,i);
            }
        }
        return maxlength;
    }
}
