class Solution {
    public String convertToTitle(int columnNumber) {

        StringBuilder sb = new StringBuilder();

        while(columnNumber > 26){
            System.out.println((columnNumber % 26)-1);
            if((columnNumber % 26) == 0) {
                sb.append('Z');
                columnNumber--;
            }
            else sb.append((char)((columnNumber % 26)-1 + 'A'));
            columnNumber /= 26;
        }
        sb.append((char)((columnNumber)-1 + 'A'));

        return sb.reverse().toString();        
    }
}