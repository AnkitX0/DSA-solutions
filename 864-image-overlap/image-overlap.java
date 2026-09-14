class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        
        int n = img2.length;
        int maxCounter = 0;

        for (int row = -(n-1); row < n; row++){
            for(int col = -(n-1); col < n; col++){

                int counter = 0;
                for (int i = 0; i < n; i++){
                    for (int j = 0; j < n; j++){

                        if(i+row < 0 || i+row >= n || j+col < 0 || j+col >=n) continue;

                        if(img1[i][j] == 1 && img2[i+row][j+col] == 1) counter++; 
                    }
                }
                maxCounter = counter > maxCounter ? counter : maxCounter;
            }
        }

        return maxCounter;
    
    }
}