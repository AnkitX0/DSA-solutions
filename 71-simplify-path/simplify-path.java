class Solution {
    public String simplifyPath(String path) {
        
        Deque <String> dq = new ArrayDeque<>();

        String[] strArr = path.split("/");

        for (String str: strArr){

            if(str.equals("") || str.equals(".")) continue;

            else if (str.equals("..")) {if(!dq.isEmpty())dq.pollLast();}

            else dq.addLast(str);
        }

        StringBuilder sb = new StringBuilder();

        if(dq.isEmpty()) return "/";

        while(!dq.isEmpty()){
            sb.append("/").append(dq.pollFirst());
        }
        return sb.toString();
    }
}