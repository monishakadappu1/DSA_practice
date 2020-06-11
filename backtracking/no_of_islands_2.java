/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    /**
     * @param n: An integer
     * @param m: An integer
     * @param operators: an array of point
     * @return: an integer array
     */
     int[] r={-1,0,1,0};
     int[] c={0,1,0,-1};
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // write your code here
        List<Integer> result = new ArrayList<Integer>();
        if(operators==null || operators.length==0 || n==0 || m==0)
        {
            return result;
        }
        int[][] islands = new int[n][m];
        for(int k=0;k<operators.length;k++)
        {
            int[][] check = new int[n][m];
            islands[operators[k].x][operators[k].y]=1;
            int count = 0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    if(islands[i][j]==1)
                    {
                        count = count+dfs(islands,check,i,j);
                    }
                }
            }
            result.add(count);
        }
        return result;
    }
    
    public int dfs(int[][] island,int[][] check,int row,int col)
    {
        int n = island.length;
        int m = island[0].length;
        if(row<0 || row>=n || col<0 || col>=m)
        {
            return 0;
        }
        if(check[row][col]==1)
        {
            return 0;
        }
        if(island[row][col]==1)
        {
            check[row][col]=1;
            int count = 1;
            for(int k=0;k<4;k++)
            {
                dfs(island,check,row+r[k],col+c[k]);
            }
            return count;
        }
        return 0;
    }
}
