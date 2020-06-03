class Pair{
    int stval;
    int min;
    public Pair(int val,int minval)
    {
        stval = val;
        min = minval;
    }
    
}
class MinStack {
    Stack<Pair> minstack;
    /** initialize your data structure here. */
    public MinStack() {
        minstack = new Stack<Pair>();
    }
    
    public void push(int x) {
        
        if(minstack.empty())
        {
            Pair p = new Pair(x,x);
            minstack.push(p);
        }
        else{
            Pair p;
            if(x<minstack.peek().min)
            {
                p = new Pair(x,x);
            }
            else{
                p=new Pair(x,minstack.peek().min);
            }
            minstack.push(p);
        }
    }
    
    public void pop() {
        minstack.pop();
    }
    
    public int top() {
        return minstack.peek().stval;
    }
    
    public int getMin() {
        return minstack.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
