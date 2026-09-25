class Solution {
    HashSet<List<Integer>> set = new HashSet<>();
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        if(candidates[0] > target) return new ArrayList<>();

        for (int i = 0; i < candidates.length; i++) {
            backtrack (i, candidates, target, new ArrayList<>(), 0);
        }
        for (List<Integer>lis : set){
            result.add(lis);
        }
        return result;        
    }

    public void backtrack (int i, int[] cand, int target, List<Integer>lis, int sum){
        
        if (sum > target || i >= cand.length) return;
        if (sum == target){
            set.add(new ArrayList<>(lis));
            return;
        }

        sum += cand[i];
        lis.add(cand[i]);
        backtrack(i, cand, target, lis, sum);
        
        sum -= cand[i];
        lis.remove(lis.size() - 1);

        backtrack(i + 1, cand, target, lis, sum);


    }
}