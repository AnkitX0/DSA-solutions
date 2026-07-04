class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        
        int counter  = 0;
        int arr[] = new int [26];
        // Arrays.fill(arr, 0);
        for(char ch : allowed.toCharArray()) arr[ch-'a'] = 1;

        boolean check = false;
        for(String word : words){

            for(char ch : word.toCharArray()){
                if(arr[ch-'a'] == 0){
                    check = true;
                    break;
                } 
            }    
            if(check){
                check = false;
                continue;
            }
            counter++;
        }

        return counter;

    }
}