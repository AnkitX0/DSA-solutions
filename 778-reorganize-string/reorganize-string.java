class Pair{
    char ch;
    int count;
    public Pair(char ch, int count){
        this.ch = ch;
        this.count = count;
    }
}
class Solution {
    public String reorganizeString(String s) {
        PriorityQueue<Pair> pq = new PriorityQueue<>( (a,b) -> b.count - a.count);
        int[] map = new int[26];

        for(char ch : s.toCharArray()){
            map[ch-'a']++;
            if(map[ch-'a'] > (s.length()+1)/2) return "";
        }
        for(int i = 0; i < 26; i++){
            if(map[i] > 0){
                pq.add(new Pair((char)('a'+i), map[i]));
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(pq.size() > 1){
            Pair p1 = pq.poll();
            Pair p2 = pq.poll();

            sb.append(p1.ch);
            sb.append(p2.ch);

            if(p1.count-- > 1) pq.add(p1);
            if(p2.count-- > 1) pq.add(p2);
        }
        if(!pq.isEmpty()){Pair p2 = pq.poll();
        sb.append(p2.ch);}

        return sb.toString();
    }
}