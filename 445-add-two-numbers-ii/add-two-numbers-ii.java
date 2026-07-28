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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode prev1 = null;
        ListNode prev2 = null;
        
        while(l1 != null){
            ListNode curr = l1.next;
            l1.next = prev1;
            prev1 = l1;
            l1 = curr;
        }

        while(l2 != null){
            ListNode curr = l2.next;
            l2.next = prev2;
            prev2 = l2;
            l2  = curr;
        }
        int carry = 0;

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while(prev2 != null || prev1 != null || carry > 0){
            int sum = carry;

            if(prev2 != null){
                sum += prev2.val;
                prev2 = prev2.next;
            }
            if(prev1 != null){
                sum += prev1.val;
                prev1 = prev1.next;
            }

            ListNode newNode = new ListNode(sum % 10);
            carry = sum / 10;
            temp.next = newNode;
            temp = temp.next;
        }

        dummy = dummy.next;
        ListNode result = null;
        while(dummy != null){
            ListNode curr = dummy.next;
            dummy.next = result;
            result = dummy;
            dummy = curr;
        }

        return result;
    }
}