class Solution {
    int[][] dp;
    public int minCut(String s) {
        if(s.length()==0 ||s.length()==1)
        {
            return 0;
        }
        dp = new int[s.length()][s.length()];
        int n = s.length();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                dp[i][j]=-1;
            }
        }
        return solve(s,0,n-1);
    }
    
    public int solve(String s,int i,int j)
    {
        if(i>=j)
        {
            return 0;
        }
        if(ispalindrome(s,i,j)==true)
        {
            return 0;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for(int k=i;k<j;k++)
        {
            int temp = 1+solve(s,i,k) + solve(s,k+1,j);
            if(temp<min)
            {
                min = temp;
            }
        }
        dp[i][j] = min;
        return dp[i][j];
    }
    
    public boolean ispalindrome(String s,int i,int j)
    {
        while(i<=j && s.charAt(i)==s.charAt(j))
        {
            i++;
            j--;
        }
        if(i>j)
        {
            return true;
        }
        return false;
    }
}

//one last test case doesnot pass with this
