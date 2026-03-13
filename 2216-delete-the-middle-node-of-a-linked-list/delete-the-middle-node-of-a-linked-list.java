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
    public ListNode deleteMiddle(ListNode head) {
        
        if(head.next == null) return null;

        ListNode fast = head;
        ListNode slow = new ListNode(0);
        ListNode dummy = slow;
        slow.next = fast;
        
        while(fast != null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
            // System.out.println(slow.val+ " " + fast.val);
        }
        slow.next = slow.next.next;

        return dummy.next;
    }
}