class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();

        int idx = 0;
        for(int i = 1; i <= n && idx < target.length; i++){
            list.add("Push");
            if(i == target[idx]){
                idx++;
            }
            else{
                list.add("Pop");
            }
        }
        return list;
    }
}