class Solution {
    public String smallestPalindrome(String s) {

        int n = s.length();
        int arr[] = new int[26];
        char res[] = new char[n];

        for(char ch : s.toCharArray()){
            arr[ch-'a']++;
        }

        int left = 0;
        int right = n - 1;
        for(int i = 0; i < 26; i++){
            
            char ch = (char)('a' + i);
            while(arr[i] >= 2){
                res[left++] = ch;
                res[right--] = ch;
                arr[i] -= 2;
            }

            if(arr[i] == 1){
                res[n / 2] = ch;
                arr[i]--;
            }
        }
        return new String (res);
    }
}