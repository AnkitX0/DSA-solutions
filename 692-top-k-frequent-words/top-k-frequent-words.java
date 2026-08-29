class Pair{
    String word;
    int freq;
    public Pair(String w, int f){
        this.word = w;
        this.freq = f;
    }
}
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>( (b, a) -> {
            if(a.freq == b.freq) {
                return b.word.compareTo(a.word);
            }
            return Integer.compare(a.freq, b.freq);
        });
        HashMap<String, Integer> map = new HashMap<>();

        for(String str : words){
            map.put(str, map.getOrDefault(str, 0)  + 1);
        }

        for( String str : map.keySet()){
            pq.add(new Pair (str, map.get(str)));
        }

        List<String> ans = new ArrayList<>();
        while(k-- > 0){
            ans.add(pq.poll().word);
        }
        return ans;
    }
}