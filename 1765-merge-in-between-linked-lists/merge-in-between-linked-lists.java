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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        
        ListNode curr = list1;

        ListNode left = curr;
        b = b-a;
        while(curr != null && a-- > 0) {
            left = curr;
            curr = curr.next;
        }
        while(curr != null && b-- >= 0) {
            curr = curr.next;
        }
        left.next = list2;
        while(list2.next != null) list2 = list2.next;
        list2.next = curr;

        return list1;
        
    }
}