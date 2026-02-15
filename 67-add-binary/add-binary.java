class Solution {
    public String addBinary(String a, String b) {
        int n = a.length()-1;
        int m = b.length()-1;

        int sum = 0;
        int carry = 0;

        StringBuilder sb = new StringBuilder();

        while(m >= 0 || n>=0){
             sum = carry;

            if(n >= 0) sum += (a.charAt(n) - '0');

            if(m >= 0) sum += (b.charAt(m) - '0');

            if(sum > 1) carry = 1;
            else carry = 0;

            sb.insert(0, (char) ('0' + sum%2));

            m--;n--;
        }
        if(carry == 1) sb.insert(0, '1');

        return sb.toString();
    }
    
}