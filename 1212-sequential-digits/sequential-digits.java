class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        
        List<Integer> result = new ArrayList<>();
        int size = String.valueOf(low).length();
        int first = String.valueOf(low).charAt(0) - '0';
        
        if(first + size > 10) {
            first = 1;
            size++;
        }
        int copy = size++;
        int num = 0;
        int eleven = 0;
        while(copy-- > 0){
            num = (num * 10) + first++;
            eleven = eleven *10 + 1;
        }

        while (num <= high){
            if(num >= low )result.add(num);
            // result.add(num);
            if(num % 10 == 9){
                first = 1;
                num = 0;
                copy = size++;
                while(copy-- > 0){
                    num = (num * 10) + first++;
                }
                eleven = eleven *10 + 1;
                continue;
            }
            num += eleven;

        }
        
        return result;
    }
}