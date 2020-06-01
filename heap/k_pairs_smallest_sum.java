class Solution {
    public class SumPoints{
        int first;
        int sec;
        int sum;
        public SumPoints(int a, int b)
        {
            first = a;
            sec = b;
            sum = a+b;
        }
    }
    public class sumCompare implements Comparator<SumPoints>
    {
        @Override
        public int compare(SumPoints a,SumPoints b)
        {
            return (b.sum-a.sum);
        }
    }
    
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(k==0 || nums1.length==0 || nums2.length==0)
        {
            return res;
        }
        PriorityQueue<SumPoints> pq = new PriorityQueue<SumPoints>(k,new sumCompare());
        int count = 0;
        for(int i=0;i<nums1.length;i++)
        {
            for(int j=0;j<nums2.length;j++)
            {
                SumPoints sump = new SumPoints(nums1[i],nums2[j]);
                if(count<k)
                {
                    pq.add(sump);
                }
                else{
                    int temp = pq.peek().sum;
                    if(sump.sum<temp)
                    {
                        pq.poll();
                        pq.add(sump);
                    }
                }
                count++;
            }
        }
        int n = pq.size();
        for(int t=0;t<k;t++)
        {
            if(t<n)
            {
                SumPoints temp = pq.poll();
                List<Integer> resl = new ArrayList<Integer>();
                resl.add(temp.first);
                resl.add(temp.sec);
                res.add(resl);
            }
            
        }
        return res;
    }
}
