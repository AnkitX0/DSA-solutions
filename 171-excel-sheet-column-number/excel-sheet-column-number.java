class Solution {
    public int titleToNumber(String columnTitle) {

        int num = 0;

        for(char ch : columnTitle.toCharArray()){
            num = (num *  26) + (ch-'A') + 1;
        }   
        return num;
    }
}