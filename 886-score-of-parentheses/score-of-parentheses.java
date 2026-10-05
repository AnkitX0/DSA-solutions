class Solution {
    public int scoreOfParentheses(String s) {
        int sum = 0;

        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < s.length(); i ++){
            if(s.charAt(i) == '('){
                stk.push(sum);
                sum = 0;
                continue;
            }
            if(s.charAt(i-1) == ')'){
                sum = stk.pop() + (2*sum);
            }
            else sum = stk.pop() + 1;
            
        }
        return sum;
    }

}