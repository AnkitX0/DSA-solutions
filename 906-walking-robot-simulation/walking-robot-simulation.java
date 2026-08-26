class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        HashSet<String> str = new HashSet<>();

        for(int obs[] : obstacles){
            str.add(obs[0]+ " " + obs[1]);
        }

        int dir = 0;
        int x = 0;
        int y = 0;
        int maxDist = 0;

        int[][] direction = new int[][]{
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
        };

        for(int i : commands){

            if(i == -1) dir = (dir+1) % 4;
            else if (i == -2) dir = (dir+3) % 4;
            else{
                while(i > 0){
                    int nx = x + direction[dir][0];
                    int ny = y + direction[dir][1];

                    if(str.contains(nx + " " + ny)) break;

                    x = nx;
                    y = ny;
                    i--;
                }
            }
            maxDist = Math.max(maxDist, (x*x + y*y));
        }
        return maxDist;
    }
}