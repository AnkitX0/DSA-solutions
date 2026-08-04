class BrowserHistory {

    class Node{
        Node next;
        Node prev;
        String val;

        Node(String val){
            this.val = val;
        } 
    }

    Node curr;
    public BrowserHistory(String homepage) {
        curr = new Node(homepage);
    }
    
    public void visit(String url) {
        Node newNode = new Node(url);

        curr.next = newNode;
        newNode.prev = curr;
        curr = newNode;
        curr.next = null;
    }
    
    public String back(int steps) {
        while(curr.prev != null  && steps-- > 0){
            curr = curr.prev;
        }
        return curr.val;
    }
    
    public String forward(int steps) {

        while(curr.next != null  &&  steps-- > 0){curr = curr.next;}
        return curr.val;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */