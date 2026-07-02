class Solution {
    public String restoreString(String s, int[] indices) {
        
        char[] arr = new char[indices.length];
        String str = "";
        int idx = 0;
        for(int i : indices){
            arr[i] = s.charAt(idx);
            idx++;
        }

        for(char ch : arr){
            str += String.valueOf(ch);
        }

        return str;
    }
}