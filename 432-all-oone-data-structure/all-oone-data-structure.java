public class Node{

    int count;
    Node next;
    Node prev;
    List<String> list = new ArrayList<>();
    Node (int val){
        this.count = val;
    }
    
}
class AllOne {

    HashMap<String, Node> map = new HashMap<>();
    Node head;
    Node last;
    public AllOne() {
        head = new Node(-1);
        last = new Node(-1);
        head.next = last;
        last.prev = head;
    }

    private void insert(Node prevNode, Node newNode){
        Node nextNode = prevNode.next;
        prevNode.next = newNode;
        newNode.prev = prevNode;
        newNode.next = nextNode;
        nextNode.prev = newNode;
    }

    private void removeNode(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
    
    public void inc(String key) {
        
        if(!map.containsKey(key)){

            if(head.next == last || head.next.count != 1){
                Node newNode = new Node(1);
                insert(head, newNode);
            }
            head.next.list.add(key);
            map.put(key, head.next);
        }
        else {

            Node curr = map.get(key);
            Node next = curr.next;

            if(next == last || next.count != curr.count + 1){
                Node newNode = new Node(curr.count + 1);
                insert(curr, newNode);
                next = newNode;
            }
            next.list.add(key);
            map.put(key, next);

            curr.list.remove(key);
            if( curr.list.isEmpty()){
                removeNode(curr);
            }

        }
    }
    
    public void dec(String key) {
        if (!map.containsKey(key)) return;

        Node node = map.get(key);
        node.list.remove(key); // O(n)

        if (node.count == 1) {
            map.remove(key);
        } else {
            Node prev = node.prev;
            if (prev == head || prev.count != node.count - 1) {
                Node newNode = new Node(node.count - 1);
                insert(node.prev, newNode);
                prev = newNode;
            }
            prev.list.add(key);
            map.put(key, prev);
        }

        if (node.list.isEmpty()) {
            removeNode(node);
        }

    }
    
    public String getMaxKey() {
        if(last.prev == head) return "";
        return last.prev.list.get(0);
    }
    
    public String getMinKey() {
        if(head.next == last) return "";
        return head.next.list.get(0);
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */