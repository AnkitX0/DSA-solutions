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
    public ListNode removeNodes(ListNode head) {

        ListNode prev = null;

        while(head != null){
            ListNode curr = head.next;
            head.next = prev;
            prev = head;
            head = curr;
        }   

        ListNode slow = prev;
        ListNode fast = prev.next;

        while(fast != null){
            if(fast.val < slow.val){
                fast = fast.next;
            }
            else{
                slow.next = fast;
                slow = slow.next;
                fast = fast.next;
            }
        }
        slow.next = null;

        while(prev != null){
            ListNode curr = prev.next;
            prev.next = head;
            head = prev;
            prev = curr;
        }   

        return head;
    }
}