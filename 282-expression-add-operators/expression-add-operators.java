class Solution {
    List<String> res = new ArrayList<>();
    char[] arith = new char[] {'*', '+', '-'};
    
    public List<String> addOperators(String num, int target) {

        char number[] = num.toCharArray();
        backtrack(number, 0, target, new StringBuilder());

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
                res.add(sb.toString());
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