class Solution {
    public int minimumPushes(String word) {
        int ans = 0;
        
        int arr[] = new int[26];

        for(int i = 0; i < word.length(); i++){
            arr[ word.charAt(i) - 'a']++;
        }

        Arrays.sort(arr);
        int counter = 8;
        for(int i = 25; i >= 0; i--){
            if(arr[i] == 0) break;
            ans += (counter / 8) * arr[i];
            counter++;
        }

        return ans;
        
    }
}