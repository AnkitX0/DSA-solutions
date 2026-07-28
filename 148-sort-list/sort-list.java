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
    public ListNode sortList(ListNode head) {
         
        PriorityQueue <Integer> pq = new PriorityQueue<>();

        while(head != null){
            pq.add(head.val);
            head = head.next;
        }
        head = new ListNode(0);
        ListNode temp = head;
        while(!pq.isEmpty()){
            ListNode node = new ListNode(pq.poll());
            temp.next = node;
            temp = temp.next;
        }

        return head.next;        
    }
}