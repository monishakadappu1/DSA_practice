class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        if(T.length==0)
        {
            return res;
        }
        Stack<Integer> temp = new Stack<Integer>();
        for(int i=0;i<T.length;i++)
        {
            if(temp.size()==0)
            {
                temp.push(i);
            }
            else{
                int cur = T[i];
                while(!temp.empty() && cur>T[temp.peek()])
                {
                    int prev = temp.pop();
                    int diff = i-prev;
                    res[prev] = diff;
                }
                temp.push(i);
            }
        }
        return res;
    }
}
