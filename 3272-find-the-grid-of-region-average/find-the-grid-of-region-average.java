class Solution {
    public int[][] resultGrid(int[][] image, int threshold) {
        
        int m = image.length;
        int n = image[0].length;
        int result[][] = new int[m][n];
        int count[] [] = new int[m][n];

        // for(int row[] : result)Arrays.fill(row, -1);

        for(int i = 0; i <= m-3; i++){
            for(int j = 0; j <= n - 3; j++){
                boolean pixel = true;

                for(int x = i; x < i+3; x++){
                    for(int y = j; y < j+3; y++){

                            if(x < i+2 && Math.abs(image[x][y] - image[x+1][y]) > threshold) {
                                pixel = false;
                                break;
                            }
                            if(y < j + 2 && Math.abs(image[x][y] - image[x][y+1]) > threshold){
                                pixel = false;
                                break;
                            }
                        
                            if(!pixel) break;
                        }
                    if(!pixel) break;
                }

                if(pixel) {
                    int avg = average(i, j, image);
                    for(int x = i; x < i+3; x++){
                        for(int y = j; y < j+3; y++){
                                result[x][y] += avg;
                                count[x][y]++;
                        }
                    }
                }
            }
        }
 
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(count[i][j] == 0){
                    result[i][j] = image[i][j];
                } else {
                    result[i][j] /= count[i][j];
                }
            }
        }
        return result;
    }

    public int average(int m, int n, int[][]image){
        
        int sum = 0;
        for(int i = m; i < m+3; i++){
            for(int j = n; j < n+3; j++){
                sum += image[i][j];
            }
        }
        return sum/9;
    }
}