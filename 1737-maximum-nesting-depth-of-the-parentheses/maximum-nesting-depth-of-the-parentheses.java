class Solution {
    public int maxDepth(String s) {

        Stack <Integer> stk = new Stack<>();
        int i = 0;
        int size = 0;
        while (i < s.length()){
            
            if(s.charAt(i) == '('){
                stk.push(1);
                size = Math.max(stk.size(), size);
            }
            else if(s.charAt(i) == ')'){
                stk.pop();
            }
            i++;
        }
        return size;
        
    }
}