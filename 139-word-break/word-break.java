class Solution {
    private Boolean[] t;
    int n; 
    List<String> wd;

    public boolean wordBreak(String s, List<String> wordDict) {
        n =s.length();
        t = new Boolean[n];
        wd = wordDict;
        return solve(s, 0);    
    }

    private boolean solve(String s, int idx){
        if(idx == n) return true;

        if(t[idx] != null) return t[idx];

        for(int end = idx+1; end <= n; end ++){
            String spt = s.substring(idx, end);

            if(wd.contains(spt) && solve(s, end)) return t[idx] = true;
        }
        return t[idx] = false;
    }
}