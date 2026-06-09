class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        
        List<Integer> result = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>();

        for (String st : words){
            map.put(st, map.getOrDefault(st, 0) + 1);
        }

        int size = words[0].length();
        int wordSize = words.length;

        for(int i = 0; i < size; i++){
            
            int left = i;
            int counter = 0;

            HashMap<String, Integer> copy = new HashMap<>();

            for (int right = i; right <= s.length() - size; right+= size){

                String st = s.substring(right, right + size);
                
                if (map.containsKey(st)){

                    copy.put(st, copy.getOrDefault(st, 0) + 1);
                    counter++; 
                    
                    while(copy.get(st) > map.get(st)){

                        String leftStr = s.substring(left, left + size);
                        copy.put (leftStr, copy.get(leftStr) - 1);

                        left += size;
                        counter--;
                    }

                    if(counter == wordSize){
                        result.add(left);
                        String leftStr = s.substring(left, left + size);
                        copy.put (leftStr, copy.get(leftStr) - 1);

                        left += size;
                        counter--;
                    }
                }
                else {
                    copy.clear();
                    counter = 0;
                    left = right + size;
                }
            }
        }
        return result;
    }
}