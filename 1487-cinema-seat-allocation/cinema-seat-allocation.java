class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int row[] : reservedSeats){
            int seat = 1 << row[1];
            map.put(row[0],(map.getOrDefault(row[0], 0) | seat));
        }

        int grp = (n - map.size()) * 2;

        for(int key : map.keySet()){
            int num = map.get(key);

            boolean rowA = avail(num, 2, 5);
            boolean rowB = avail(num, 4, 7);
            boolean rowC = avail(num, 6, 9);

            if(rowA && rowC) grp += 2;
            else if (rowA || rowB || rowC) grp += 1; 
        }

        return grp;
    }

    public boolean avail(int num, int start, int end){

        for(; start <= end; start++){
            if((num & (1 << start)) != 0) return false;
        }
        return true;
    }
}