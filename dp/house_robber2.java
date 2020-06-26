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
        int n = nums.length;
        int first = houserob(nums,0,n-1);
        int sec = houserob(nums,1,n);
        int res = Math.max(first,sec);
        return res;
    }
    public int houserob(int[] nums,int start,int end)
    {
        int[] dp = new int[nums.length];       
        
        for(int i=start;i<end;i++)
        {
            dp[i]=nums[i];
        }
        for(int i=start+2;i<end;i++)
        {
            for(int j=start;j<i-1;j++)
            {
                if((dp[j]+nums[i])>dp[i])
                {
                    dp[i] = dp[j]+nums[i];
                }
            }
        }
        int maxval = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            if(dp[i]>maxval)
            {
                maxval = dp[i];
            }
        }
        return maxval;
    }
        
    
}
