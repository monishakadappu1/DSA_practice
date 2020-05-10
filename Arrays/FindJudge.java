class Solution {
    public int findJudge(int N, int[][] trust) {
        int tarr[] = new int[N+1];  //[ 0,0,0,0]
        int total = trust.length;  //total = 3
        for(int i=0;i<total;i++)
        {
            tarr[trust[i][1]]++; //tarr[3] = [ 0,0,0,1] tarr[3]=[ 0,-1,0,2] [ 0,0,-1,2] 
            tarr[trust[i][0]]--;// [ 0,-1,0,1], [0,-1,-1,2],[0,0,-1,1]
        }
        for(int i=1;i<=N;i++)
        {
            if(tarr[i]==N-1)
            {
                return i;
            }
        }
        return -1;
    }
}
