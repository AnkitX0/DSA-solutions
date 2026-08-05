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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head;
        int grp = 1;

        ListNode prevGroup = dummy;
        while(curr != null){
            ListNode temp = curr;
            ListNode grpLast = temp;
            ListNode grpStart = temp;
            int counter = grp;
            int count = 0;
            while(temp != null && counter-- > 0){
                grpLast = temp;
                temp = temp.next;
                count++;
            }

            if(count % 2 == 0){
                grpLast.next = null;
                ListNode prev = null;
                ListNode start = grpStart;

                while(grpStart != null){
                    ListNode cur = grpStart.next;
                    grpStart.next = prev;
                    prev = grpStart;
                    grpStart = cur;
                }    

                start.next = temp;
                prevGroup.next = prev;
                prevGroup = start;
                curr = temp;
                
            }
            else {
                counter = grp;
                while(curr != null && counter-- > 0){
                    prevGroup = curr;
                    curr = curr.next;
                }
            }
            grp++;
        }
        return head;
    }
}