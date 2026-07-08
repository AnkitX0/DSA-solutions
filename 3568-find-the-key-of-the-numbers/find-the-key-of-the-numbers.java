class Solution {
    public int generateKey(int num1, int num2, int num3) {
        
        int num = 0;
        int i = 0;
        while(num1 > 0 && num2 > 0 && num3 > 0){
            int mini = ((int) Math.min(num1 % 10, Math.min(num2 % 10, num3 % 10)));
            num1 /= 10;
            num2 /= 10;
            num3 /= 10;

            num += (int)Math.pow(10, i++) * mini;
        }
        return num;
    }
}