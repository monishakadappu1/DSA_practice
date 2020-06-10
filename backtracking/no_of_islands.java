class Solution {
    ArrayList<ArrayList<Integer>> direct;
    HashSet<ArrayList<Integer>> set;
    
    public Solution(){
        ArrayList<Integer> first = new ArrayList<Integer>();
        first.add(-1);
        first.add(0);
        ArrayList<Integer> sec = new ArrayList<Integer>();
        sec.add(0);
        sec.add(1);
        ArrayList<Integer> third = new ArrayList<Integer>();
        third.add(1);
        third.add(0);
        ArrayList<Integer> fourth = new ArrayList<Integer>();
        fourth.add(0);
        fourth.add(-1); 
        direct = new ArrayList<ArrayList<Integer>>();
        direct.add(first);
        direct.add(sec);
        direct.add(third);
        direct.add(fourth);
        set = new HashSet<ArrayList<Integer>>();
        
    }
    
    public int numIslands(char[][] grid) {
       if(grid.length==0)
       {
           return 0;
       } 
        int count = 0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
                ArrayList<Integer> pair = new ArrayList<Integer>();
                pair.add(i);
                pair.add(j);
                if(!set.contains(pair))
                {
                   
                    if(grid[i][j]=='1')
                    {
                        count = count+1;
                        searchisland(grid,pair);
                        set.add(pair);
                    }                    
                    
                }
            }
        }
        return count;
    }
    
    public int searchisland(char[][] grid ,ArrayList<Integer> pair)
    {
        int k = pair.get(0);
        int l = pair.get(1);
        int in = grid.length;
        int jn = grid[k].length;
        int flag = 0;
        for(int d = 0;d<direct.size();d++)
        {
            int first = direct.get(d).get(0);
            int sec = direct.get(d).get(1);
            int i = k+first;
            int j = l+sec;
            
            if(i>=0 && i<in && j>=0 && j<jn)
            {
                if(grid[i][j]=='1')
                {
                    ArrayList<Integer> arr = new ArrayList<Integer>();
                    arr.add(i);
                    arr.add(j);
                    if(!set.contains(arr))
                    {
                        
                        flag = 1;
                        set.add(arr);
                        searchisland(grid,arr);
                    }
                }
                
            }
        }
        return flag;
    }
    
    
    
}
