class Solution {
    HashSet<String> set = new HashSet<>();
    String tiles;

    public int numTilePossibilities(String tiles) {
        this.tiles = tiles;
        recursion(new boolean[tiles.length()], new StringBuilder());

        System.out.println(set);
        return set.size();

    }

    public void recursion(boolean[] visited, StringBuilder sb){
        // if(i > tiles.length()) return;
        if(sb.length() != 0)set.add(sb.toString());

        for(int j = 0; j < tiles.length(); j++){
            if(visited[j]) continue;
            sb.append(tiles.charAt(j));
            visited[j] = true;
            recursion(visited, sb);
            visited[j] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}