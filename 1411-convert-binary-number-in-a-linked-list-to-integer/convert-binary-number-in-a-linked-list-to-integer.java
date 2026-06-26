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
    public int getDecimalValue(ListNode head) {
        
        int result = 0;
        int counter = -1;
        ListNode temp = head;

        while(temp != null){
            counter++;
            temp = temp.next;
        }
        while(head != null){
            int bit = head.val;
            int ans = (int)Math.pow(2, counter--);
            if(bit == 1) result += ans;
            head = head.next;
        }

        return result;
    }
}