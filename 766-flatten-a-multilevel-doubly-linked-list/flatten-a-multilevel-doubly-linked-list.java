/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        
        Node curr = head;
        Node prev = curr;
        while(curr!= null){
            prev = curr;
            curr = dfs(curr);
        }
        
        return head;
    }

    private Node dfs(Node root){
        
        Node temp = root;
        if(temp.child != null){
            Node tempNext = temp.next;
            Node tempRoll = temp.child;

            temp.child = null;
            root.next = tempRoll;
            tempRoll.prev = temp;

            while(tempRoll.next != null) tempRoll = tempRoll.next;

            tempRoll.next = tempNext;
            if(tempNext != null )tempNext.prev = tempRoll;
        }

        return root.next;
    }
}