class Solution {
    public String[] createGrid(int m, int n) {

        String[] ans = new String[m];

        for (int i = 0; i < m; i++){
            String str = "";
            for (int j = 0; j < n; j++){

                if(i == 0 || j == n - 1)  str+=".";
                else if( i == 2 && j == n - 2) str += ".";
                else str += "#";
            }

            ans[i] = str;
        }

        return ans;
    }
}