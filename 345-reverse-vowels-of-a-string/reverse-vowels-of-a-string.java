class Solution {
    public String reverseVowels(String s) {
        
        int left = 0;
        int right = s.length() - 1;

        StringBuilder sb = new StringBuilder (s);
        char[] charList = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        List<Character> ch = new ArrayList<>();
        for (char c : charList) {
            ch.add(c);
        }

        while(left <= right){

            if(ch.contains(sb.charAt(left)) && ch.contains(sb.charAt(right))){
                char temp = sb.charAt(left);
                sb.setCharAt(left, sb.charAt(right));
                sb.setCharAt(right, temp) ;
                left++;
                right--;
            }
            else if (!ch.contains(sb.charAt(left)) ) left++;
            else right --;
        }

        return sb.toString();
    }
}