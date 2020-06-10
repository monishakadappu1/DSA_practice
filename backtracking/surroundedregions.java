class Solution {
    int row[] = {-1,0,1,0};
    int col[] = {0,-1,0,1};
    public void solve(char[][] board) {
        if(board.length==0 || board[0].length==0)
        {
            return;
        }
        int rn = board.length;
        int cn = board[0].length;
        for(int i=0;i<rn;i++)
        {
            for(int j=0;j<cn;j++)
            {
                if(i==0 || i==rn-1 || j==0 || j==cn-1)
                {
                    if(board[i][j]=='O')
                    {
                        dfs(board,rn,cn,i,j);
                    }
                }
            }
        }
        for(int i=0;i<rn;i++)
        {
            for(int j=0;j<cn;j++)
            {
                if(board[i][j]=='*')
                {
                    board[i][j]='O';
                }
                else{
                    board[i][j] ='X';
                }
            }
        }
        return;
    }
    
    public void dfs(char[][] board,int rn,int cn,int i,int j)
    {
        if(i<0 || i>=rn || j<0||j>=cn){
            return;
        }
        if(board[i][j]=='*' || board[i][j]=='X')
        {
            return;
        }
        board[i][j]='*';
        for(int k=0;k<4;k++)
        {
            int t = i+row[k];
            int w = j+col[k];
            dfs(board,rn,cn,t,w);
        }
        return;
    }
}
