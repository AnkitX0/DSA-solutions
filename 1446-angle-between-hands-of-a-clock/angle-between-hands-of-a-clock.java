class Solution {
    public double angleClock(int hour, int minutes) {
        
        if(hour == 12) hour = 0;
         
        double hrsDeg = ((hour )* 30) + (0.5 * minutes);
        double minDeg  = (minutes * 6);

        System.out.println(hrsDeg);
        System.out.println(minDeg);

        double res = Math.abs(hrsDeg - minDeg); 
        return Math.min(res, 360 - res); 
    }
}