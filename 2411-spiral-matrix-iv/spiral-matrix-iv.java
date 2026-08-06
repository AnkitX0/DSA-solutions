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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        
        int matrix[][] = new int[m][n];

        int left = 0;
        int top = 0;
        m--;n--;
        
        while(top <= m && left <= n){
            
            for(int i = left; i <= n; i++){
                if(head == null)matrix[top][i] = -1;
                else{
                    matrix[top][i] = head.val;
                    head = head.next;
                }
            }
            top++;

            for(int i = top; i <= m; i++){
                if(head == null) matrix[i][n] = -1;
                else{
                    matrix[i][n] = head.val;
                    head = head.next;
                }
            }
            n--;

            if(top > m) break;

            for(int i = n; i >= left; i--){
                if(head == null)matrix[m][i] = -1;
                else{
                    matrix[m][i] = head.val;
                    head = head.next;
                }
            }
            m--;

            if(left > n) break;

            for(int i = m; i >= top; i--){
                if(head == null)matrix[i][left] = -1;
                else{
                    matrix[i][left] = head.val;
                    head = head.next;
                }
            }
            left++;

        }
       
        
        return matrix;
    }
}