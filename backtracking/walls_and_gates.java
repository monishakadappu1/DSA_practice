public class Solution {
    /**
     * @param rooms: m x n 2D grid
     * @return: nothing
     */
     int[] wallr ={-1,0,1,0};
     int[] wallc = {0,1,0,-1};
    public void wallsAndGates(int[][] rooms) {
        // write your code here
        for(int i=0;i<rooms.length;i++)
        {
            for(int j=0;j<rooms[i].length;j++)
            {
                if(rooms[i][j]==0)
                {
                    dfs(i,j,0,rooms);
                }
            }
        }
    }
    
    public void dfs(int row,int col, int dist,int[][] rooms)
    {
        
        int rows = rooms.length;
        int cols = rooms[0].length;
        if(row<0 || row>=rows || col<0 || col>=cols || dist>rooms[row][col])
        {
            return;
        }
        rooms[row][col] = dist;
        for(int k=0;k<4;k++)
        {
            dfs(row+wallr[k],col+wallc[k],dist+1,rooms);
        }
    }
}
