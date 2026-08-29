class Pair{
    char ch;
    int freq;
    public Pair(char ch, int f){
        this.ch = ch;
        this.freq = f;
    }
}
class Solution {
    public String frequencySort(String s) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.freq, a.freq));
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)  +1);
        }
        
        for(char c : map.keySet()){
            pq.add(new Pair(c, map.get(c)));
        }
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            Pair ch = pq.poll();
            while(ch.freq-- > 0) sb.append(ch.ch);
        }

        return sb.toString();
    }
}