class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(k==1 && nums.length==0)
        {
            return 0;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k);
        for(int i=0;i<nums.length;i++)
        {
            if(i<k)
            {
                pq.add(nums[i]);
            }
            else{
                int data = pq.peek();
                if(data<nums[i])
                {
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
        }
        return pq.peek();
    }
}
