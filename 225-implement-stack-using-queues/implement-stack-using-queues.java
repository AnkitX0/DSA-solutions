class MyStack {
Deque <Integer> qu ;
    public MyStack() {

         qu = new ArrayDeque<>();
        // int top = -1;
    }
    
    public void push(int x) {
        qu.add(x);
    }
    
    public int pop() {
        return qu.pollLast();
    }
    
    public int top() {
        return qu.peekLast();
        
    }
    
    public boolean empty() {
        return qu.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */