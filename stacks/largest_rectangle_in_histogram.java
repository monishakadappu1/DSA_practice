class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights.length==0)
        {
            return 0;
        }
        int maxarea = Integer.MIN_VALUE;
        Stack<Integer> ht = new Stack<Integer>();
        for(int i=0;i<heights.length;i++)
        {
            if(ht.empty())
            {
                ht.push(i);
            }
            else{
                int next = heights[i];
                while(!ht.empty() && next<heights[ht.peek()])
                {
                    int cur = ht.pop();
                    int diff=0;
                    if(ht.empty())
                    {
                        diff = i-(-1)-1;                        
                    }
                    else{
                        diff = i-(ht.peek())-1;                        
                    }
                    int area = diff * heights[cur];
                    maxarea = Math.max(maxarea,area);
                }
                ht.push(i);
            }
        }
        if(ht.size()>0)
        {
            int n = heights.length;
            while(!ht.empty())
            {
                int cur = ht.pop();
                int diff=0;
                if(ht.empty())
                {
                    diff = n-(-1)-1;                        
                }
                else{
                    diff = n-(ht.peek())-1;                        
                }
                int area = diff * heights[cur];
                maxarea = Math.max(maxarea,area);
            }
        }
        return maxarea;
    }
}
