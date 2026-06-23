class MinStack {

    Stack <Integer> minStk , stk;

    public MinStack() {
        minStk = new Stack<>();
        stk = new Stack<>();
    }
    
    public void push(int value) {
        
        if(minStk.isEmpty()) minStk.push(value);
        else if(value <= minStk.peek()) minStk.push(value);
        stk.push(value);
    }
    
    public void pop() {
        if(!stk.isEmpty() ) {
            if (stk.peek().equals(minStk.peek())) minStk.pop();
            stk.pop();
        }
    }
    
    public int top() {
        return stk.peek();        
    }
    
    public int getMin() {
        return minStk.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */