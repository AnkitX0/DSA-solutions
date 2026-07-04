class Solution {
    public String addStrings(String num1, String num2) {
        
        StringBuilder sb = new StringBuilder("");
        int num1Size = num1.length() -1;
        int num2Size = num2.length() -1;
        int size = Math.max(num1Size, num2Size);

        int carry = 0;

        for(int i = 0; i <= size; i++){
            int m = 0;
            int n = 0;

            if(i <= num1Size) m = num1.charAt(num1Size - i) - '0';
            if(i <= num2Size) n = num2.charAt(num2Size - i) - '0';

            int sum = m + n + carry;

            sb.insert(0, String.valueOf(sum % 10));
            carry = sum / 10;
        }
        if(carry > 0)sb.insert(0, String.valueOf(carry));
            

        return sb.toString();
    }
}