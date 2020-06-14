class Solution {
    int[] arr;
    public int climbStairs(int n) {
       if(n==0 || n==1)
       {
           return 1;
       }
        if(n==2)
        {
            return 2;
        }
        arr = new int[n+1];
        arr[0]=1;
        arr[1]=1;
        arr[2]=2;
        return dp(n);
    }
    public int dp(int n)
    {
        if(n<0)
        {
            return 0;
        }
        if(arr[n]!=0)
        {
            return arr[n];
        }
        arr[n] = dp(n-1)+dp(n-2);
        return arr[n];
    }
    
    
}
