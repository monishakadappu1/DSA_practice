public class Solution {
    /**
     * @param nums: the given array
     * @return: the minimum difference between their sums 
     */
    public int findMin(int[] nums) {
        if(nums.length==0)
        {
            return 0;
        }
        if(nums.length==1)
        {
            return nums[0];
        }
        int sum = 0;
        int n = nums.length;
        for(int i=0;i<n;i++)
        {
            sum = sum+nums[i];
        }
        int halfsum = sum/2;
        boolean[][] dp = new boolean[n+1][halfsum+1];
        for(int i=0;i<n+1;i++)
        {
            dp[i][0] = true;
        }
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<=halfsum;j++)
            {
                if(nums[i-1]>j)
                {
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - nums[i-1]];
                }
            }
        }
        ArrayList<Integer> subarr = new ArrayList<Integer>();
        for(int j=1;j<=sum/2;j++)
        {
            if(dp[n][j]==true)
            {
                subarr.add(j);
            }
        }
        int minval = Integer.MAX_VALUE;
        for(int i=0;i<subarr.size();i++)
        {
            minval = Math.min(minval,(sum-(2 * subarr.get(i))));
        }
        return minval;
    }
}
