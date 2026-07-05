class Solution {
     public static Map<Integer, String> d = new HashMap<>();

    static {
        d.put(0, "Zero");
        d.put(1, "One");
        d.put(2, "Two");
        d.put(3, "Three");
        d.put(4, "Four");
        d.put(5, "Five");
        d.put(6, "Six");
        d.put(7, "Seven");
        d.put(8, "Eight");
        d.put(9, "Nine");
        d.put(10, "Ten");
        d.put(11, "Eleven");
        d.put(12, "Twelve");
        d.put(13, "Thirteen");
        d.put(14, "Fourteen");
        d.put(15, "Fifteen");
        d.put(16, "Sixteen");
        d.put(17, "Seventeen");
        d.put(18, "Eighteen");
        d.put(19, "Nineteen");
        d.put(20, "Twenty");
        d.put(30, "Thirty");
        d.put(40, "Forty");
        d.put(50, "Fifty");
        d.put(60, "Sixty");
        d.put(70, "Seventy");
        d.put(80, "Eighty");
        d.put(90, "Ninety");
        d.put(100, "Hundred");
        d.put(1000, "Thousand");
        d.put(1000000, "Million");
        d.put(1000000000, "Billion");
    }

    private String convert(int n) {
    String name = "";

    if (n >= 100) {
        name += d.get(n / 100) + " Hundred";
        n %= 100;
        if (n != 0) name += " ";
    }

    if (n >= 20) {
        name += d.get((n / 10) * 10);
        if (n % 10 != 0)
            name += " " + d.get(n % 10);
    } else if (n > 0) {
        name += d.get(n);
    }

    return name;
}

    public String numberToWords(int num) {
        
        if(num == 0) return "Zero";
        String ans = "";
        int[] sum = new int[4];
        int i = 3;
        while(num > 0){
            sum[i] = num % 1000;
            num /= 1000;
            i--;
        }

    
        i = 0;
        String[] value = {"Billion","Million","Thousand",""};
        for(; i < 4; i++){
            if(sum[i] == 0) continue;

            String part = convert(sum[i]);
            ans += part;
            if(!value[i].isEmpty())
            ans += " " + value[i];

            ans += " ";
        }

        return ans.trim();
    }
}