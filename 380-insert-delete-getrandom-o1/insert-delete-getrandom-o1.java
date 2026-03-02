import java.util.*;

class RandomizedSet {
    HashMap<Integer, Integer> map;
    private ArrayList<Integer> lis ;

    public RandomizedSet() {
        map = new HashMap<>();    
        lis = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        lis.add(val);
        map.put(val, lis.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        int index = map.get(val);
        int lastElement = lis.get(lis.size() - 1);

        lis.set(index, lastElement);
        map.put(lastElement, index);
        lis.remove(lis.size() - 1);
        map.remove(val);

        return true;
    }

    public int getRandom() {

        Random random = new Random();
        int randomIndex = random.nextInt(lis.size()); 

        return lis.get(randomIndex);

    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */