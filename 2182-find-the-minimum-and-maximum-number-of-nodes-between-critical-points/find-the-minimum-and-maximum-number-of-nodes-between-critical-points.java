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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        
        int result[] = new int[]{-1, -1};
        List<Integer> critical = new ArrayList<>();

        ListNode curr = head.next;
        ListNode prev = head;
        int idx = 2;
        while(curr.next != null){

            if(curr.val > prev.val && curr.val > curr.next.val) critical.add(idx);
            else if(curr.val < prev.val && curr.val < curr.next.val) critical.add(idx);
            prev = curr;
            curr = curr.next;
            idx++;
        }

        if(critical.size() < 2) return result;
        int min = critical.get(critical.size() - 1) - critical.get(critical.size() - 2);
        result[1] = critical.get(critical.size() - 1) -  critical.get(0);
        
        
        for(int i = 1; i < critical.size(); i++){
            min = Math.min(min, critical.get(i) - critical.get(i - 1));
        }
        result[0] = min;
        return result;
    }
}