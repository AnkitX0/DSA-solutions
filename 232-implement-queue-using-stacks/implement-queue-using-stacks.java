class MyQueue {

    Deque <Integer>stk;

    public MyQueue() {
        stk = new ArrayDeque<>();
    }
    
    public void push(int x) {
        stk.addLast(x);
    }
    
    public int pop() {
        return stk.pollFirst();
    }
    
    public int peek() {
        return stk.peekFirst();
    }
    
    public boolean empty() {
        return stk.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */