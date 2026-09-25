class Solution {
    public int clumsy(int n) {
        Stack<Integer> stk = new Stack<>();

        int dir = 0;
        // int dir = 0; multi
        // int dir = 1; div
        // int dir = 2; add
        // int dir = 3; sub
        stk.push(n--);
        while(n >= 1){

            if(dir == 0){
                stk.push(n * stk.pop());
            }
            else if(dir == 1){
                stk.push(stk.pop() / n);
            }
            else if(dir == 3){
                stk.push(n * -1);
            }
            else stk.push(n);

            dir = (dir+1)%4;
            n--;
        }

        int sum = 0;
        while(!stk.isEmpty()){
            sum += stk.pop();
        }
        return sum;
    }
}