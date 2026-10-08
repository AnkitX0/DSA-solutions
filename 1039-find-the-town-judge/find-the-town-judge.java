class Solution {
    public int findJudge(int n, int[][] trust) {

        // boolean person[] = new boolean[n + 1];
        int person[] = new int[n + 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int t[] : trust){
            person[t[1]]++;
            map.put(t[0], t[1]);
        }   

        for(int i = 1; i <= n; i++){
            if(person[i] >= n-1 && !map.containsKey(i)) return i;
        }
        // System.out.println(person);
        return -1;
    }
}