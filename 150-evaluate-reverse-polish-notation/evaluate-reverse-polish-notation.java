class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack <Integer> stk = new Stack<>();

        for(String str : tokens){

            if(str.equals("+")){
                stk.push(stk.pop() + stk.pop());
            }
            else if (str.equals("-")){
                int val = stk.pop();
                stk.push(stk.pop() - val);
            }
            else if(str.equals("*")){
                stk.push(stk.pop() * stk.pop());
            }
            else if(str.equals("/")){
                int val = stk.pop();
                stk.push(stk.pop() / val);
            }
            else stk.push(Integer.parseInt(str));
        }

        return stk.pop();
        
    }
}