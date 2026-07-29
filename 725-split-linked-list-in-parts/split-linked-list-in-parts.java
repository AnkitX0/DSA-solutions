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
    public ListNode[] splitListToParts(ListNode head, int k) {
        
        ListNode[] ans = new ListNode[k];
        int size = 0;
        ListNode curr = head;
        while(curr != null){
            size++;
            curr = curr.next;
        }

        int partition = size / k;
        int extra = size % k;   

        curr = head;
        for(int i = 0; i < k; i++){
            
            if(curr == null){
                ans[i] =null;
                continue;
            }
            int ele = partition + (extra-- > 0 ? 1 : 0);
            ListNode fast = curr;
            ListNode prev = null;
            while(fast != null && ele-- > 0){
                prev = fast;
                fast = fast.next;
            }
            prev.next = null;
            ans[i] = curr;
            curr = fast;
        }    

        return ans;
    }
}