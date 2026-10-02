class Solution {
    List<String> result ;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        recursion(n, 0, 0, sb);

        return result;
    }

    private void recursion(int n, int start,int end, StringBuilder sb){
        if(sb.length() == 2 * n) {
            result.add(sb.toString());
            return;
        }

        if(start < n){
            sb.append('(');
            recursion(n, start + 1, end, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(end < start){
            sb.append(')');
            recursion(n, start, end + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
