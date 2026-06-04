class Solution {
    
    public List<Long> maximumEvenSplit(long finalSum) {
        
        List<Long> result = new ArrayList<>();

        if(finalSum % 2 != 0) return result;

        long num = 2L;
        while(num <= finalSum){
            result.add(num);
            finalSum -= num;
            num+=2L;
        }

        result.set(result.size()-1, result.get(result.size()-1) + finalSum);
        
        return result;
    }


}