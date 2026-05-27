class Solution {
    public int numberOfSpecialChars(String word) {

        HashMap <Character, Integer> CH = new HashMap<>();
        HashMap <Character, Integer> ch = new HashMap<>();
        int counter = 0;
        
        for(int i = 0; i < word.length(); i++){

            char c = word.charAt(i);
            char nc = (char)(c + 32);

            // System.out.println(c + " " + nc);

            if(c >= 'a' && c <= 'z') ch.put(c, i);

            else if (c >= 'A' && c <= 'Z' && !CH.containsKey(nc))CH.put(nc, i);

        }


        for(Character key : CH.keySet()){
            if(CH.containsKey(key) && ch.containsKey(key) && CH.get(key) > ch.get(key)) counter++;
        }

        return counter;

    }
}