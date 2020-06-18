class Solution {
    public boolean canPartition(int[] nums) {
        if(nums.length==0||nums.length==1)
        {
            return false;
        }
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum = sum+nums[i];
        }
        if(sum%2!=0)
        {
            return false;
        }
        return subsetsum(nums,sum/2);
    }
    
    public boolean subsetsum(int[] nums,int sum)
    {
        boolean[][] dp = new boolean[nums.length+1][sum+1];
        for(int i=0;i<nums.length+1;i++)
        {
            dp[i][0]=true;
        }
        for(int i=1;i<nums.length+1;i++)
        {
            for(int j=1;j<sum+1;j++)
            {
                if(nums[i-1]>j)
                {
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = (dp[i-1][j])||(dp[i-1][j-nums[i-1]]);
                }
            }
        }
        return dp[nums.length][sum];
    
    }
}
