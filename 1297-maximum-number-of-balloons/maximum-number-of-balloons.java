class Solution {
    public int maxNumberOfBalloons(String text) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet <Character> set = new HashSet<>();

        String word = "balloon";
        for(char ch : word.toCharArray()) set.add(ch);


        for(char ch : text.toCharArray()){
            if(set.contains(ch)){
                if(!map.containsKey(ch)) map.put(ch, 1);
                else map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }
        if(map.size() < 5) return 0;
        int ans = Integer.MAX_VALUE;
        for( char key : map.keySet()){
            if(key == 'l' || key == 'o') ans = Math.min(ans, map.get(key) / 2);
            else ans = Math.min(ans, map.get(key)); 
        }

        return ans;
    }
}