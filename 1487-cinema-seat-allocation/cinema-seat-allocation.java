class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for(int row[] : reservedSeats){
            HashSet<Integer> set = map.containsKey(row[0]) ? map.get(row[0]) : new HashSet<>(); 
            set.add(row[1]);
            map.put(row[0], set);
        }

        int result = (n - (map.size())) * 2;

        for(int key : map.keySet()){
            boolean grpA = avail(map.get(key), 2, 5);
            boolean grpB = avail(map.get(key), 4, 7);
            boolean grpC = avail(map.get(key), 6, 9);

            if(grpA && grpC) result += 2;
            else if (grpA || grpB || grpC) result += 1;
        }
        return result;
    }

    public boolean avail(Set<Integer> set, int start, int end){
        for(; start <= end; start++){
            if(set.contains(start)) return false;
        }
        return true;
    }
}