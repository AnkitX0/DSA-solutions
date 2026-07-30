class Solution {
    public int minimumPushes(String word) {
        int ans = 0;

        int size = word.length();
        for(int i = 8; i < size + 8; i++){
            ans += i / 8;
        }
        return ans;
    }
}