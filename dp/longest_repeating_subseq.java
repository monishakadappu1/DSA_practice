/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public void lrs(String s)
    {
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<n+1;j++)
            {
                if(s.charAt(i-1)==s.charAt(j-1) && i!=j)
                {
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[n][n]);
        return;
    }
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		GFG g = new GFG();
		for(int i=0;i<T;i++){
		    int n = sc.nextInt();
		    String s = sc.next();
		    g.lrs(s);
		}
	}
}
