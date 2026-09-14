class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        
        int n = img2.length;
        int maxCounter = 0;

        // // 1 bits left
        // for (int idx = n-1; idx >= 0; idx--) {
        //     counter = 0;
        //     for (int i = 0; i < m; i++){
        //         for (int j = 0; j < n; j++){
        //             if (idx+j >= n) break;
        //             if (img1[i][j] == 1 && 1 == img2[i][j+idx]) counter++;
        //         }
        //     }
        //     maxCounter = maxCounter < counter ? counter : maxCounter;
        // }    
        // // 1 bit right
        // for(int idx = 1; idx < n; idx++){
        //     counter = 0;
        //     for (int i = 0; i < m; i++){
        //         for (int j = 0; j < n; j++){
        //             if (j-idx < 0) break;
        //             if (img1[i][j] == 1 && 1 == img2[i][j-idx]) counter++;
        //         }
        //     }
        //     maxCounter = maxCounter < counter ? counter : maxCounter;
        // }

        // // 1 bits up
        // for (int idx = m-1; idx >= 0; idx--) {
        //     counter = 0;
        //     for (int i = 0; i < m; i++){
        //         if (idx+i >= m) break;
        //         for (int j = 0; j < n; j++){
        //             if (img1[i][j] == 1 && 1 == img2[i + idx][j]) counter++;
        //         }
        //     }
        //     maxCounter = maxCounter < counter ? counter : maxCounter;
        // }    
        // // 1 bit down
        // for(int idx = 1; idx < m; idx++){
        //     counter = 0;
        //     for (int i = 0; i < m; i++){
        //         if (i-idx < 0) break;
        //         for (int j = 0; j < n; j++){
        //             if (img1[i][j] == 1 && 1 == img2[i - idx][j]) counter++;
        //         }
        //     }
        //     maxCounter = maxCounter < counter ? counter : maxCounter;
        // }
        

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