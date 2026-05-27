class Solution {
    public List<List<Integer>> generate(int numRows) {


        List<List<Integer>> result = new ArrayList<>();
        
        for(int i = 0; i < numRows; i++){
            
            List<Integer> list = new ArrayList<>(Collections.nCopies(i + 1, 1));
            
            for(int j = 1; j < i; j++){
                int ans = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                list.set(j, ans);
            }
            result.add(list);
        }

        return result;   
    }
}