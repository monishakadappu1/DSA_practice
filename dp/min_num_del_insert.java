/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public int lcs(String str1,String str2)
    {
        
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<m+1;j++)
            {
                if(str1.charAt(i-1)==str2.charAt(j-1))
                {
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
                // System.out.println("dp value");
                // System.out.println(dp[i][j]);
            }
        }
        return dp[n][m];
    }
    
    public void insertdelete(String str1,String str2, int n,int m)
    {
        if(n==0 && m==0)
        {
            System.out.println(0);
            return;
        }
        if(n==0)
        {
            System.out.println(m);
            return;
        }
        if(m==0)
        {
            System.out.println(n);
            return;
        }
        // System.out.println("inside insertion");
        // System.out.println(str1);
        // System.out.println(str2);
        int lcslength = lcs(str1,str2);
        
        // System.out.println("n and m are");
        // System.out.println(n);
        // System.out.println(m);
        // System.out.println("lcs length");
        // System.out.println(lcslength);
        int add = m - lcslength;
        int del = n - lcslength;
        System.out.println(add+del);
        return;
        
    }
    
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int T = sc.nextInt();
		GFG g = new GFG();
		for(int i=0;i<T;i++)
		{
		    int n = sc.nextInt();
		    int m = sc.nextInt();
		    String str1 = sc.next();
		    String str2 = sc.next();
		    g.insertdelete(str1,str2,n,m);
		}
		
	}
}
