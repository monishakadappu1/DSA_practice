/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public void checksub(String s1, String s2)
    {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<m+1;j++)
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
        if(dp[n][m]==n)
        {
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }
        return;
    }
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		GFG g = new GFG();
		for(int i=0;i<T;i++)
		{
		    String s1 = sc.next();
		    String s2  = sc.next();
		    g.checksub(s1,s2);
		}
	}
}
