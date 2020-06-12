public class Solution {
    /**
     * @param grid: a list of lists of integers
     * @return: return an integer, denote the number of distinct islands
     */
    //  String start = "X";
    //  String left = "L";
    //  String right ="R";
    //  String up = "U";
    //  String down = "D";
    //  String end_Z = "O";
     HashSet<String> set = new HashSet<String>();
     String cur = "";
    public int numberofDistinctIslands(int[][] grid) {
        if(grid.length == 0 || grid[0].length==0)
        {
            return 0;
        }
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
                if(grid[i][j]==1)
                {
                    //cur = cur + start;
                    String path = dfs(grid,i,j,"X");
                    if(!set.contains(path))
                    {
                        set.add(path);
                    }
                    //cur = "";
                }
            }
        }
        return set.size();
    }
    
    public String dfs(int[][] grid,int i,int j, String direct)
    {
        int n = grid.length;
        int m = grid[0].length;
        if(i<0 || i>=n || j<0 || j>=m || grid[i][j]==0)
        {
            //cur = cur + end_Z;
            return "O";
        }
        
        grid[i][j]=0;
        //cur = cur+left;
        String left = dfs(grid,i,j-1,"L");
        //cur = cur+right;
        String right = dfs(grid,i,j+1,"R");
        //cur = cur+up;
        String up = dfs(grid,i-1,j, "U");
        //cur = cur + down;
        String down = dfs(grid,i+1,j,"D");
        return direct+left+right+up+down;

    
    }
}
