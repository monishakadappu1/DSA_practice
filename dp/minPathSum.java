class Solution {
    public int minPathSum(int[][] grid) {
      if(grid.length==0 || grid[0].length == 0)
      {
          return 0;
      }
        int n = grid.length;
        int m = grid[0].length;
        for(int j=1;j<m;j++)
        {
            grid[0][j] = grid[0][j-1]+grid[0][j];
        }
        for(int i = 1;i<n;i++)
        {
            grid[i][0] = grid[i-1][0] + grid[i][0];
        }
        for(int i=1;i<n;i++)
        {
            for(int j = 1;j<m;j++)
            {
                grid[i][j] = grid[i][j]+Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[n-1][m-1];
    }
}

//the path taken
// i = n-1;
// j=m-1;
// Arraylist<Integer> res;
// while(i>=0 &&  j>=0)
// {
//     cursum = arr[i][j];
//     first = arr[i-1][j];
//     sec = arr[i][j-1];
//     mini =0;
//     minj = 0;
//     if(first<sec){mini = i-1;minj = j;}
//     else{mini = i;minj = j-1;}
//     val = cursum - arr[mini][minj];
//     res.add(val);
//     i=mini;
//     j=minj;
// }
// return res;
