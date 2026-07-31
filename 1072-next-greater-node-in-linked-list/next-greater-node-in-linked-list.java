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
    public int[] nextLargerNodes(ListNode head) {
        
        ListNode prev = head;
        int size = 0;
        while(prev != null){
            prev = prev.next;
            size++;
        }
        int[] arr = new int[size];
        
        ListNode slow = head;
        int idx = 0;
        while(slow != null){
            ListNode fast = slow;

            while(fast != null && fast.val <= slow.val){
                fast = fast.next;
            }

            if(fast != null) arr[idx++] = fast.val;
            else arr[idx++] = 0;
            slow = slow.next;
        } 

       
        return arr;
    }
}