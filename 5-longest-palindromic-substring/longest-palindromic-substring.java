class Solution {
    int n;
    String str;

    public String longestPalindrome(String s) {
        n = s.length();
        if(n==1) return s;
        String maxStr = "";
        str = s;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n-1; i++){
            palin(i,i+1,sb);
            if(sb.length() > maxStr.length()) maxStr = sb.toString();
            sb.delete(0, sb.length());
            
            sb.append(s.charAt(i));
            palin(i-1,i+1,sb);
            if(sb.length() > maxStr.length()) maxStr = sb.toString();
            sb.delete(0, sb.length());
            
        }

        return maxStr;
    }

    private void palin(int left, int right, StringBuilder sb){
        if(left<0 || right >= n || str.charAt(left)!= str.charAt(right)) return;

        sb.insert(0,str.charAt(left));
        sb.append(str.charAt(right));

        palin(left-1, right+1, sb);
    }
}
