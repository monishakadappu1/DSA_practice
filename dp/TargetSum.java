class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if(nums.length==0)
        {
            return 0;
        }
        if(nums.length==1)
        {
            if(nums[0]==S || nums[0]==(S*-1))
            {
                return 1;
            }
            else{
                return 0;
            }
        }
        int sum = 0;
        int n = nums.length;
        for(int i=0;i<n;i++)
        {
            sum = sum+ nums[i];
        }
        if(sum<S)
        {
            return 0;
        }
        int s1 = (sum+S);
        if(s1%2!=0)
        {
            return 0;
        }
        int s = s1/2;
        int[][] dp = new int[n+1][s+1];
        dp[0][0] = 1;
        for(int i=1;i<n+1;i++)
        {
            if(nums[i-1]==0)
            {
                dp[i][0] = 2 * dp[i-1][0];
            }
            else{
                dp[i][0] = dp[i-1][0];
            }
        }
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<s+1;j++)
            {
                if(j<nums[i-1])
                {
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j]+dp[i-1][j-nums[i-1]];
                }
                //System.out.println(dp[i][j]);
            }
        }
        return dp[n][s];
    }
}
