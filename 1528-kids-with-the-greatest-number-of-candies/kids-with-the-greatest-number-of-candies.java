class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        List<Boolean> result = new ArrayList<>();
        
        int great = 0;
        for(int i : candies) great = Math.max(i, great);

        for(int i : candies) {
            if(i + extraCandies >= great) result.add(true);
            else result.add(false);
        }
        return result;
    }
}