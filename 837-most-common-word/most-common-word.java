class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();

        paragraph = paragraph.toLowerCase().replaceAll("[^a-z ]", " ");

        for(String str : paragraph.split("\\s+")){    
            if(!map.containsKey(str)) map.put(str, 0);
            map.put(str, map.get(str) + 1);
         }

         for(String str : banned){
            set.add(str);
         }



        String result = "";
        int freq = 0;

         for(String str : map.keySet()){
            if(set.contains(str))continue;

            if(map.get(str) > freq){
                freq = map.get(str);
                result = str;
            }
         }

         return result;
    }
}