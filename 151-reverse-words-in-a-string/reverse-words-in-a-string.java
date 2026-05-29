class Solution {
    public String reverseWords(String s) {
        
        String[] str = s.replaceAll("\\s+", " ").trim().split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i = str.length - 1; i >= 0; i--){
            sb.append(str[i]);
            if(i != 0) sb.append(" ");
        }
        return sb.toString();
    }
}