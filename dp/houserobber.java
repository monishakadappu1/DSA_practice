class Solution {
    public int rob(int[] nums) {
        if(nums.length==0)
        {
            return 0;
        }
        if(nums.length==1)
        {
            return nums[0];
        }
        int n=nums.length;
        int[] dp=new int[n];
        for(int i=0;i<n;i++)
        {
            dp[i]=nums[i];
        }
        for(int i=2;i<n;i++)
        {
            for(int j=0;j<i-1;j++)
            {
                if((dp[j]+nums[i])>dp[i])
                {
                    dp[i] = dp[j]+nums[i];
                }
            }
        }
        int maxval = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            if(dp[i]>maxval)
            {
                maxval = dp[i];
            }
        }
        return maxval;
    }
}
