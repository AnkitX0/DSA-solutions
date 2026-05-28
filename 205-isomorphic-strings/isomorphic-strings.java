class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        HashMap<Character, Character> map = new HashMap<>();
        HashMap<Character, Character> mapFor_t = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            
            if (map.containsKey(s.charAt(i))){
                                
                if(map.get(s.charAt(i)) != t.charAt(i)) return false;
            }
            else
                map.put(s.charAt(i), t.charAt(i));

            if(mapFor_t.containsKey(t.charAt(i))) {
                if ( mapFor_t.get(t.charAt(i)) != s.charAt(i) ) return false;
            }

            else {
                mapFor_t.put( t.charAt(i), s.charAt(i));
            }
        }
        return true;
    }
}