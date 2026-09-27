class Solution {
    public String reverseParentheses(String s) {

        Stack<String> stk = new Stack<>();
        int i = 0;
        StringBuilder sb = new StringBuilder("");

        while( i < s.length()){
                
                if( s.charAt(i) == '('){
                    stk.push(sb.toString());
                    sb.setLength(0);
                }
                else if( s.charAt(i) == ')'){
                    if(stk.size() >= 1) stk.push(stk.pop() + sb.reverse().toString());
                    else stk.push(sb.reverse().toString());
                    sb = new StringBuilder(stk.pop());
                }
                else sb.append(s.charAt(i));
                i++;
                
                if(!stk.isEmpty()) System.out.println(stk.peek());
            }
        return sb.toString();
        // return "";
    }
}