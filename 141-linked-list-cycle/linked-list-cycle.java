/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

        int maxLimit = 10002;
        int counter = 0;
        while(head != null ){
            head = head.next;
            counter++;
            if(counter > maxLimit) return true;
        }

        return false;   
    }
}