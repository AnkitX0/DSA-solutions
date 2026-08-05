/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        
        ListNode curr = head;
        int counter = 0;
        while(curr != null){
            counter++;
            curr = curr.next;
        }

        ListNode secondNode = head;
        counter = counter - k + 1;
        while(counter-- > 1) {
            secondNode = secondNode.next;
        }

        ListNode firstNode = head;
        while(k-- > 1){
            firstNode = firstNode.next;
        }
        
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
        return head;
    }
}