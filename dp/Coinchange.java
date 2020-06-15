class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0)
        {
            return -1;
        }
        if(amount==0)
        {
            return 0;
        }
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int i=1;i<amount+1;i++)
        {
            dp[0][i] = Integer.MAX_VALUE-1;
        }
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<amount+1;j++)
            {
                if(coins[i-1]>j)
                {
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                }
            }
        }
        int val = dp[n][amount];
        if(val == Integer.MAX_VALUE-1)
        {
            return -1;
        }
        return val;
    }
    
}
    
    
