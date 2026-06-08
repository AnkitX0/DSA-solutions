class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap <String, List<String>> hash = new HashMap<>();
        for (String str : strs){
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String key = new String(temp);

            if(!hash.containsKey(key))
                hash.put(key, new ArrayList<>());
            hash.get(key).add(str);
        }        
        return new ArrayList<>(hash.values());
    }
}