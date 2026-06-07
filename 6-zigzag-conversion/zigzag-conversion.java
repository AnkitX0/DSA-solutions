class Solution {
    public String convert(String s, int numRows) {
        
        if(numRows == 1) return s;

        String[] ans = new String[numRows];
        for(int i = 0; i < numRows; i++){
            ans[i] = "";
        }

        int idx = 0;
        while(idx < s.length()){
            for(int i = 0; i < numRows && idx < s.length(); i++){
                ans[i] += s.charAt(idx++);
            }

            for(int i = numRows - 2; i > 0 && idx <s.length(); i--){
                ans[i] += s.charAt(idx++);
            }
        }

        String str = "";
        for(String ch : ans) str += ch;
        
        return str;
    }
}