class Solution {
    public String getHint(String secret, String guess) {
        
        int bullCounter = 0;

        HashMap<Integer, Integer> secretMap = new HashMap<>();
        HashMap<Integer, Integer> guesstMap = new HashMap<>();

        for(int i = 0 ; i < secret.length(); i++){
            int se = secret.charAt(i) - '0';
            int ge = guess.charAt(i) - '0';
            if( se == ge) bullCounter++;
            else {
                secretMap.put(se, secretMap.getOrDefault(se, 0) + 1);
                guesstMap.put(ge, guesstMap.getOrDefault(ge, 0) + 1);
            }
        }
        int guessCounter = 0;

        for(int key : guesstMap.keySet()){
            if(secretMap.containsKey(key)) {
                guessCounter += Math.min(guesstMap.get(key), secretMap.get(key));
            }
        }

        return "" + bullCounter + "A" + guessCounter +"B";
    }
}