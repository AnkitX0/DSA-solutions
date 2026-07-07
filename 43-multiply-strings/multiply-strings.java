class Solution {
    private String sum (String num1, String num2){
        
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


    public String multiply(String num1, String num2) {
            if(num1.equals("0") || num2.equals("0")) return "0";
            int size2 = num2.length() - 1;
            String[] arr = new String[size2 + 1];
            int power = 0;

            while (size2 >= 0) {
                StringBuilder sb = new StringBuilder();
                int carry = 0;   

                int n2 = num2.charAt(size2) - '0';            
                for(int i = num1.length()- 1; i >=0; i--){
                    int n1 = (num1.charAt(i))-'0';
                        int val = (n1 * n2) + carry;
    
                        sb.insert(0, val % 10);
                        carry = val / 10;
                    }

                if (carry > 0)
                    sb.insert(0, carry);

                for (int i = 0; i < power; i++)
                    sb.append("0");

                arr[power] = sb.toString();power++;
                size2--;
            }

            for(int i = 1; i < arr.length; i++){
                arr[i] = sum(arr[i -1], arr[i]);
            }

            return arr[arr.length - 1];
    }
}