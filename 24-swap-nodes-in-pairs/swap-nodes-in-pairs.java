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
    public ListNode swapPairs(ListNode head) {
        if(head == null)return null;
        if(head.next == null) return head;

        ListNode temp = head;
        ListNode fast = head.next;

        ListNode demo = new ListNode(0);
        ListNode currt = demo;

        while(temp != null && fast != null){
            currt.next = fast;
            temp.next = fast.next;
            currt.next.next = temp;
            currt = currt.next.next;
            temp = temp.next;

            if(temp != null) fast = temp.next;
            else fast = null;          
        }


        return demo.next;
    }
}