class Solution {
    public String removeOuterParentheses(String s) {
        
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for (char ch : s.toCharArray()){

            if(ch == '('){
                counter++;
                if(counter > 1) sb.append("(");
            }
            else{
                counter--;
                if(counter > 0) sb.append(")");
            }
        }
        return sb.toString();
    }
}