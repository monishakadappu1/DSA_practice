/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public int lcs(String s1,String s2)
    {
        int n = s1.length();
        int[][] dp = new int[n+1][n+1];
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<n+1;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][n];
    }
    
    public void palindrome(String s)
    {
        String s1 = "";
        for(int i=s.length()-1;i>=0;i--)
        {
            s1 = s1+s.charAt(i);
        }
        int lcslen = lcs(s,s1);
        int pal = s.length()-lcslen;
        System.out.println(pal);
    }
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		GFG g = new GFG();
		for(int i=0;i<T;i++)
		{
		    String s = sc.next();
		    g.palindrome(s);
		}
	}
}
