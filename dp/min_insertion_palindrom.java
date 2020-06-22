class Solution {
    public int minInsertions(String s) {
        if(s.length()==1)
        {
            return 0;
        }
        String rev = "";
        int n = s.length();
        for(int i=n-1;i>=0;i--)
        {
            rev = rev + s.charAt(i);
        }
        //System.out.println(rev);
        int[][] dp = new int[n+1][n+1];
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<n+1;j++)
            {
                if(s.charAt(i-1)==rev.charAt(j-1))
                {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int insert = n - dp[n][n];
        return insert;
    }
}
