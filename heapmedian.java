class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> minheap;
    PriorityQueue<Integer> maxheap;
    public MedianFinder() {
        minheap = new PriorityQueue<Integer>();
        maxheap = new PriorityQueue<Integer>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        maxheap.add(num);
        int large = maxheap.poll();
        minheap.add(large);
        int minsiz = minheap.size();
        int maxsiz = maxheap.size();
        if((minsiz-maxsiz)>1){
            int temp = minheap.poll();
            maxheap.add(temp);
            System.out.println("maxheap head");
            System.out.println(maxheap.peek());
        }
    }
    
    public double findMedian() {
        int minsiz = minheap.size();
        int maxsiz = maxheap.size();
        if(minsiz == 0 && maxsiz==0)
        {
            return 0;
        }
        int sum = 0;
        if((minsiz - maxsiz)==0)
        {
            int first = maxheap.peek();
            int sec = minheap.peek();
            sum = first+sec;
            double result = (double)sum/2;
            return result;
        }
        else{
            sum = minheap.peek();
            return sum;
        }
        
                
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
