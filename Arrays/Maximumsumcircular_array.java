class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int maxsum = A[0];
        int cursum = A[0];
        int prevsum=A[0];
        for(int i=1;i<A.length;i++)
        {
            int sum = A[i]+prevsum;
            cursum = Math.max(sum,A[i]);
            maxsum = Math.max(maxsum,cursum);
            prevsum = cursum;
        }
        int flag=0;
        int kmaxsum = maxsum;
        int minsum = A[0];
        prevsum = A[0];
        int total = A[0];
        for(int i=1;i<A.length;i++)
        {
            if(A[i]>0){flag=1;}
            int sum = prevsum+A[i];
            cursum = Math.min(sum,A[i]);
            minsum = Math.min(minsum,cursum);
            total = total + A[i];
            prevsum = cursum;
        }
        int normsum = total-minsum;
        int finalsum = Math.max(normsum,kmaxsum);
        if(flag==0)
        {
            return kmaxsum;
        }
        return finalsum;
        
    }
}
