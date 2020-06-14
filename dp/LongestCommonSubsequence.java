class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length()==0 || text2.length()==0)
        {
            return 0;
        }
        int t1 = text1.length();
        int t2 = text2.length();
        int[][] arr = new int[t1+1][t2+1];
        String res = "";
        for(int i=1;i<t1+1;i++)
        {
            for(int j=1;j<t2+1;j++)
            {
                if(text1.charAt(i-1) == text2.charAt(j-1))
                {
                    arr[i][j] = 1+arr[i-1][j-1];
                    res = res+text1.charAt(i-1);
                }
                else{
                    arr[i][j] = Math.max(arr[i-1][j],arr[i][j-1]);
                }
            }
        }
        System.out.println(res);
        return arr[t1][t2];
    }
}
