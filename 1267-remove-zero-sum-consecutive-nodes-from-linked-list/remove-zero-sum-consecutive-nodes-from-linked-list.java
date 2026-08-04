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
    public ListNode removeZeroSumSublists(ListNode head) {
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;

        int sum = 0;
        HashMap<Integer, ListNode> map = new HashMap<>();

        while(temp != null){
            sum+= temp.val;
            map.put(sum, temp);
            temp = temp.next;
        }
        
        ListNode curr = dummy;
        sum = 0;

        while(curr != null){
            sum += curr.val;
            
            curr.next = map.get(sum).next;
            curr = curr.next;
        }

        return dummy.next;
    }
}