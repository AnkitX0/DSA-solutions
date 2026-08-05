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
    public ListNode mergeNodes(ListNode head) {
        
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        int sum = 0;
        head = head.next;
        while(head != null){

            if(head.val == 0){
                ListNode newNode = new ListNode(sum);
                temp.next = newNode;
                temp = temp.next;
                sum = 0;
            }
            sum += head.val;
            head = head.next;
        }

        return dummy.next;
    }
}