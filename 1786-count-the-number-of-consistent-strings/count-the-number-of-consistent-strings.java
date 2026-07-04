class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        
        int counter  = 0;
        HashSet<Character> set = new HashSet<>();

        for(int i = 0; i < allowed.length(); i++) set.add(allowed.charAt(i));

        boolean check = false;
        for(String word : words){

            for(char ch : word.toCharArray()){
                if(!set.contains(ch)){
                    check = true;
                    break;
                } 
            }    
            if(check){
                check = false;
                continue;
            }
            counter++;
        }

        return counter;

    }
}