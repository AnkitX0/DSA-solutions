class Solution {
    public String smallestPalindrome(String s) {
        
        int arr[] = new int[26];
        for(char ch : s.toCharArray()){
            arr[ch-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        String mid = "";


        // first half or palindrome
        for(int i = 0; i < 26; i++)
        {
            if( arr[i] > 0 && arr[i] % 2 != 0)  {
                mid = String.valueOf((char)('a' + i));
                arr[i]--;
            }
            
            if(arr[i] > 0){
                int val = arr[i]/2;
                while(arr[i] > val){
                    sb.append( (char)('a' + i));
                    arr[i]--;
                }
            }
        }
        sb.append(mid);
        
        // second half of string
        for(int i = 25; i >= 0; i--){
            if(arr[i] > 0){
                while(arr[i]-- > 0){
                    sb.append( (char)('a' + i));
                }
            }
        }
        return sb.toString();
    }
}