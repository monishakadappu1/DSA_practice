class KthLargest {
    int count;
    int[] nums;
    int counter;
    public KthLargest(int k, int[] numsarr) {
       count = k;
        nums = new int[numsarr.length];
        nums = numsarr; 
        int counter = 0;
    }
    
    public int add(int val) {
        if(counter==0)
        {
            int i=0;
            while(i<nums.length){
                if(i<count)
                {
                    minheapify(i);
                }
                if(i>=count)
                {
                    if(nums[0]<nums[i])
                    {
                        nums[0] = nums[i];
                        minheapify(0);
                    }
                }
                i++;
            }
            if(nums.length==0)
            {
                nums = new int[]{val};
            }
            counter=1;
        }
        if(val>nums[0])
        {
            nums[0]=val;
            minheapify(0);
        }
        return nums[0];
    }
    
    public void minheapify(int indx)
    {
        
        int parent = indx;
        int lc = 2*indx+1;
        int rc = 2*indx+2;
        int largest = -1;
        if(lc<count && lc<nums.length && nums[lc]<nums[parent])
        {
            largest = lc;
        }
        else if(rc<count && lc<nums.length && nums[rc]<nums[parent])
        {
            largest = rc;
        }
        
        if(largest!=-1)
        {
            int temp = nums[parent];
            nums[parent] = nums[largest];
            nums[largest] = temp;
            parent = largest;
            minheapify(parent);
        }
        return;
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
 
 //this code is suited if array size is fixed ,but since its a stream of integer we need to use something felxible like queue .the next code
 //is implemented in priority queue

class KthLargest {
    PriorityQueue<Integer> pQueue;
    int count;
    
    public KthLargest(int k, int[] nums) {
        count = k;
        pQueue = new PriorityQueue<Integer>(count);
        for(int i=0;i<nums.length;i++)
        {
            if(i<count)
            {
                pQueue.add(nums[i]);
            }
            else if(i>=count)
            {
                int val = pQueue.peek();
                if(val<nums[i])
                {
                    pQueue.poll();
                    pQueue.add(nums[i]);
                }
            }
        }
    }
    
    public int add(int val) {
        if(pQueue.size()<count)
        {
            pQueue.add(val);
        }
        else{
           int data = pQueue.peek();
            if(data<val)
            {
                pQueue.poll();
                pQueue.add(val);
            } 
        }
        return pQueue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
