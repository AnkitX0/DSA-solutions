class Solution {
    public int minAddToMakeValid(String s) {
        
        Stack<Character> stk = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch == '(') stk.push('(');

            else{
                if(!stk.isEmpty() && stk.peek() == '(') stk.pop();
                else stk.push(')');
            }
        }

        return stk.size();
    }
}