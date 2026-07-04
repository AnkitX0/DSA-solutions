class Solution {
    public String[] findWords(String[] words) {
        
        String firstRow = "qwertyuiop";
        String secondRow = "asdfghjkl";
        String thirdRow = "zxcvbnm";
        List<String> ans = new ArrayList<>();
        
        for(String word : words){
            String w = word.toLowerCase();
            boolean check = true;

            for(char ch : w.toCharArray()){
                if(!firstRow.contains(String.valueOf(ch))) {
                    check = false;
                    break;
                }
            }
            if(check){
                ans.add(word);
                continue;
            }
            check = true;
            
            for(char ch : w.toCharArray()){
                if(!secondRow.contains(String.valueOf(ch))) {
                    check = false;
                    break;
                }
            }
            if(check){
                ans.add(word);
                continue;
            }
            check = true;

            for(char ch : w.toCharArray()){
                if(!thirdRow.contains(String.valueOf(ch))) {
                    check = false;
                    break;
                }
            }
            if(check){
                ans.add(word);
            }

        }
        return ans.toArray(String[]::new);
    }
}