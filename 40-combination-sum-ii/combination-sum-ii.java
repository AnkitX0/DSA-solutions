class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        
        backtrack (0, candidates, target, 0, new ArrayList<>());

        return result;
    }

    public void backtrack (int i, int[]cand,int target, int sum, List<Integer>lis){
        if (target == sum){
            result.add(new ArrayList<>(lis));
            return;
        }
        if(target < sum) return;
        for(int j = i; j < cand.length; j++){
            if(j > i && cand[j] == cand[j-1]) continue;
            lis.add(cand[j]);
            backtrack(j + 1, cand, target, sum + cand[j], lis);
            lis.remove(lis.size() - 1);
            
        }
    }
}