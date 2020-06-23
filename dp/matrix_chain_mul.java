/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    int[][] dp;
    public void operations(int[] arr,int n)
    {
        dp = new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                dp[i][j]=-1;
            }
        }
        System.out.println(mcm(arr,1,n-1));
    }
    
    public int mcm(int[] arr,int i,int j)
    {
        if(i>=j)
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
            //System.out.println(arr[i-1] * arr[k] * arr[j]);
            int temp = mcm(arr,i,k) + mcm(arr,k+1,j) + (arr[i-1] * arr[k] * arr[j]);
            if(temp<min)
            {
                min = temp;
                //System.out.println(min);
            }
        }
        dp[i][j] = min;
        return dp[i][j];
    }
    
	public static void main (String[] args) {
		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt();
		GFG g = new GFG();
		for(int i=0;i<T;i++)
		{
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    for(int j=0;j<n;j++)
		    {
		        arr[j] = sc.nextInt();
		        //System.out.println(arr[i]);
		    }
		    g.operations(arr,n);
		}
	}
}
