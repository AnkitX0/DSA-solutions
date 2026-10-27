class Solution {
    List<List<String>> result;
    List<String> lis = new ArrayList<>();

    public List<List<String>> partition(String s) {    
        result = new ArrayList<>();        
        recursion(s, 0);
        
        return result;
    }

    public void recursion(String s, int i){

        if(i == s.length()){
            result.add(new ArrayList<>(lis));
            return;
        }
        
        for(int j = i+1; j <= s.length(); j++){

            String str = s.substring(i, j);

            if(isPalindrome(str)){
                lis.add(str);
                recursion(s, j);
                lis.remove(lis.size()-1);
            }    
        }
    }

    public boolean isPalindrome(String str){
        int left = 0;
        int right = str.length() -1;

        while(left < right){
            if(str.charAt(left) != str.charAt(right)) return false;
            left ++;
            right--;
        }
        return true;
    }
}