class MyCircularQueue {
    int[] CirQue;
    int front, size, capacity;
    public MyCircularQueue(int k) {
        capacity = k;
        CirQue = new int[k];
        front = 0;
        size = 0;
    }
    
    public boolean enQueue(int value) {
        if(size == capacity) return false;
        CirQue[(front+size)%capacity] = value;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if(size == 0) return false;
        front = (front+1 )% capacity; 
        size --;
        return true;
    }
    
    public int Front() {
        if(size == 0) return -1;

        return CirQue[front];
    }
    
    public int Rear() {
        if (size ==  0) return -1;

        return CirQue[(front + size - 1) % capacity];         
    }
    
    public boolean isEmpty() {
        return size == 0; 
    }
    
    public boolean isFull() {
        if(capacity == size) return true;
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */