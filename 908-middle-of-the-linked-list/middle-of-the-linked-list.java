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
    public ListNode middleNode(ListNode head) {

        int count = 1;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null ){
            count++;
            slow = slow.next;
            fast = fast.next.next;
        }
        // System.out.println(count);
        // if(count % 2 == 0) return slow;

        return slow;
        
    }
}