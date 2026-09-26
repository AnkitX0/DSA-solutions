/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> que = new LinkedList<>();
        que.add(root);

        while(!que.isEmpty()){
            int size = que.size();
            Node prev = que.poll();
            if(prev.left != null) que.add(prev.left);
            if(prev.right != null) que.add(prev.right);
            Node curr  = null;
            while(size-- > 1){
                curr = que.poll();
                prev.next = curr;
                prev = prev.next;
                if(curr.left != null) que.add(curr.left);
                if(curr.right != null) que.add(curr.right);
                
            }
            if(prev != null) prev.next = null;
        }
        
        return root;
    
        
    }
}