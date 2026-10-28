class Solution {
    List<String> res = new ArrayList<>();
    HashSet<String> set = new HashSet<>();

    char[] arith = new char[] {'*', '+', '-'};
    public List<String> addOperators(String num, int target) {

        char number[] = num.toCharArray();

        // StringBuilder sb = new StringBuilder();
        // sb.append(number[0]);
        // for(char ch : arith){
        //     sb.append(ch);
        //     backtrack(number, 1, target, sb);
        //     sb.deleteCharAt(sb.length()-1);
        // }
        backtrack(number, 0, target, new StringBuilder());

        for(String str : set){
            res.add(str);
        }
        return res;
        
    }

    public void backtrack(char[] num, int i, int target, StringBuilder sb) {
    int originalLength = sb.length();

    for (int j = i; j < num.length; j++) {
        if (j > i && num[i] == '0') {
            break;
        }

        sb.append(num[j]);

        if (j == num.length - 1) {
            if (calculate(sb) == target) {
                set.add(sb.toString());
            }
        } else {
            for (char op : arith) {
                sb.append(op);
                backtrack(num, j + 1, target, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    sb.setLength(originalLength);
}

    // public void backtrack (char[] num, int i, int target, StringBuilder sb){
        
    //    if (i == num.length) {
    //         if (sb.length() > 0 && !Character.isDigit(sb.charAt(sb.length() - 1))) {
    //             sb.deleteCharAt(sb.length() - 1);

    //             if (calculate(sb) == target) {
    //                 set.add(sb.toString());
    //             }

    //             sb.append(arith[0]);
    //         }
    //         return;
    //     }

    //     for(int j = i; j < num.length; j++){
    //         if (j > i && num[i] == '0') {
    //             break;
    //         }
    //         sb.append(num[j]);
    //         for(char ch : arith){
    //             sb.append(ch);
    //             backtrack(num, j+1, target, sb);
    //             sb.deleteCharAt(sb.length()-1);
    //         }
    //         sb.deleteCharAt(sb.length()-1);
    //     }
    // }

    public long calculate(StringBuilder sb) {
        Stack<Long> stk = new Stack<>();
        long num = 0;
        char prevOp = '+';

        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            if (!Character.isDigit(ch) || i == sb.length() - 1) {

                if (prevOp == '+') {
                    stk.push(num);
                } 
                else if (prevOp == '-') {
                    stk.push(-num);
                } 
                else if (prevOp == '*') {
                    stk.push(stk.pop() * num);
                } 
                else if (prevOp == '/') {
                    stk.push(stk.pop() / num);
                }

                prevOp = ch;
                num = 0;
            }
        }

        long ans = 0;

        while (!stk.isEmpty()) {
            ans += stk.pop();
        }

        return ans;
    }
}