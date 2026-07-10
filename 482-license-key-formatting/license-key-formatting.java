class Solution {
    public String licenseKeyFormatting(String s, int k) {
        
        s = s.toUpperCase();
        StringBuilder sb = new StringBuilder();

        int j = 0;

        for(int i  = s.length() -1; i >=0; i--){

            if(s.charAt(i) == '-') continue;

            if(j++ % k == 0){
                sb.insert(0, "-");
            }
            sb.insert(0, s.charAt(i));
        }
        if(sb.length() > 0) sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
}