class Solution {
    public String minWindow(String s, String t) {
        
        if(s.length() < t.length()) return "";

        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int start= 0;
        int l = t.length();
        int minLen = Integer.MAX_VALUE;

        while(right < s.length()){
            char ch =  s.charAt(right);

            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) - 1);
                if(map.get(ch) >= 0)l--;
            }

            while(l == 0){
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                char leftCh = s.charAt(left); 
                if(map.containsKey(leftCh)){
                    map.put(leftCh, map.get(leftCh) + 1);
                    
                    if(map.get(leftCh) > 0) l++;
                }
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}