class Solution {
    public int minimumDeletions(String s) {

        Stack <Character> stk = new Stack<>();

        int count = 0;

        for(char ch : s.toCharArray()){
            if(!stk.isEmpty() && stk.peek() == 'b' && ch == 'a'){stk.pop(); count++;}   
            else stk.push(ch); 
        }

        return count;
    }
}