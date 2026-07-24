class Solution {
    public int valueAfterKSeconds(int n, int k) {
        
        int arr[][] = new int [k + 1][n];
        for(int i = 0; i < n; i++){
            arr[0][i] = 1;
        }

        int num = 1_000_000_007;

        for(int i = 1; i <= k; i++){
            arr[i][0] = arr[i-1][0];
            for(int j = 1; j < n; j++){
                arr[i][j] = (arr[i][j-1] + arr[i -1][j])%num;
            }
        }
        return arr[k][n - 1];
    }
}