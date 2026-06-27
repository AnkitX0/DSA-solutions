class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        if(left == right) return head;
        int k = right - left  + 1;
        ListNode temp = head;
        ListNode before = null;
        ListNode prev = null;

        int count =  1;
        while(count < left){
            before = temp;
            temp = temp.next;
            count++;
        }
        ListNode pointer = temp;
        while(k-- > 0){
            ListNode curr = temp.next;
            temp.next = prev;
            prev = temp;
            temp = curr;
        }
        pointer.next = temp;

        if(before != null) before.next = prev;
        else head = prev;

        return head;
    }
}