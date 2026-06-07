class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        StringBuilder sb = new StringBuilder("");

        Arrays.sort(strs);

        int i = 0;

        while(i < strs[0].length()){
            
            if(strs[0].charAt(i) != strs[strs.length - 1].charAt(i)) break;
            sb.append(strs[0].charAt(i));
            i++;
        }

        return sb.toString();
    }
}