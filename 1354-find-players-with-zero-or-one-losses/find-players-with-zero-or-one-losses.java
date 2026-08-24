class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, Integer> losser = new HashMap<>();
        HashSet<Integer>          winner = new HashSet<>();

        List<Integer> playerWithNoLose = new ArrayList<>();
        List<Integer> playerWithOneLose = new ArrayList<>();

        for (int match[] : matches){
            winner.add(match[0]);
            losser.put(match[1], losser.getOrDefault(match[1], 0) + 1);
        }

        for(int i : losser.keySet()){
            if(losser.get(i) == 1) playerWithOneLose.add(i);
            if(winner.contains(i)) winner.remove(Integer.valueOf(i)); 
        }
        for(int i : winner) playerWithNoLose.add(i);
        
        Collections.sort(playerWithNoLose);
        Collections.sort(playerWithOneLose);

        result.add(playerWithNoLose);
        result.add(playerWithOneLose);
        
        return result;
    }
}