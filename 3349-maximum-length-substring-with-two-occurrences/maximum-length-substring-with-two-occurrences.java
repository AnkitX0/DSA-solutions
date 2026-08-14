class Solution {
    public int maximumLengthSubstring(String s) {
        
        int maxSize = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        int i = 0;
        int j = 0;
        while(i < s.length()){

            char ch = s.charAt(i);

            if(map.containsKey(ch) && map.get(ch) >= 2){

                while(map.get(ch) >= 2){
                    map.put(s.charAt(j), map.get(s.charAt(j)) -1);

                    if(map.get(s.charAt(j)) == 0) map.remove(s.charAt(j));
                    j++;
                }
            }
            map.put(ch, map.getOrDefault(ch, 0)+1);
            int sum = 0;
            for(char key : map.keySet()) sum+= map.get(key);
            maxSize = Math.max(maxSize, sum);
            i++;
        }
        return maxSize;
    }
}