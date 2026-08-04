class FrontMiddleBackQueue {
    class ListNode{
        ListNode prev;
        ListNode next;
        int val;
        public ListNode(int val) {this.val = val;}
    }

    ListNode head;
    int size = 0;
    public FrontMiddleBackQueue() {
        head = new ListNode(0);
    }
    
    public void pushFront(int val) {
        ListNode curr = new ListNode(val);
        curr.next = head.next;
        if(head.next != null){
            head.next.prev = curr;
        }
        head.next = curr;
        curr.prev = head;
        size++;
    }
    public void pushMiddle(int val) {
        ListNode newNode = new ListNode(val);

        int mid = size / 2;
        ListNode prev = head;

        for (int i = 0; i < mid; i++) {
            prev = prev.next;
        }

        newNode.next = prev.next;
        newNode.prev = prev;
        if (prev.next != null) {
            prev.next.prev = newNode;
        }
        prev.next = newNode;
        size++;
    }
        
    public void pushBack(int val) {
        ListNode newNode = new ListNode(val);
        ListNode curr = head;
        while(curr.next != null) curr = curr.next;
        curr.next = newNode;
        newNode.prev = curr;
        size++;        
    }
    
    public int popFront() {
        if (head.next == null)
            return -1;
        ListNode first = head.next;
        head.next = first.next;
        if(first.next != null){first.next.prev = head;}
        size--;
        return first.val;
    }
    
    public int popMiddle() {
        if (size == 0)
            return -1;
        int mid = (size - 1) / 2;  
        ListNode prev = head;
        for (int i = 0; i < mid; i++) {
            prev = prev.next;
        }
        ListNode del = prev.next;
        int val = del.val;
        prev.next = del.next;
        if (del.next != null) {
            del.next.prev = prev;
        }
        size--;
        return val;
    }
        
    public int popBack() {
        if(head.next == null)
        return -1;
        ListNode curr = head.next;
        ListNode last = curr;
        while(curr!= null){
            last = curr;
            curr= curr.next;
        }
        int val = last.val;
        last.prev.next = null;
        size--;
        return val;
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */