class Solution {
    int[][] check;
    public int maxAreaOfIsland(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0)
        {
            return 0;
        }
        int max_area = 0;
        int n = grid.length;
        int m = grid[0].length;
        check = new int[n][m];
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                
                if(grid[i][j]==1 && check[i][j]==0)
                {
                    int area = dfs(grid,i ,j);
                    max_area = Math.max(max_area,area);
                }
            }
        }
        return max_area;
    }
    
    public int dfs(int[][] grid,int i,int j)
    {
        int n = grid.length;
        int m = grid[0].length;
        if(i<0 || i>=n || j<0 || j>=m || grid[i][j]==0 || check[i][j]==1)
        {
            return 0;
        }
        check[i][j]=1;
        int area = 1;
        int left = dfs(grid, i,j-1);
        int right = dfs(grid,i,j+1);
        int up = dfs(grid,i-1,j);
        int down = dfs(grid,i+1,j);
        return area+left+right+up+down;
    }
}
