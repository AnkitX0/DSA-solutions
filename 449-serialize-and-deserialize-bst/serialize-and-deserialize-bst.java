/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String str = dfs(root, new String(""));
        System.out.println(str); 
        return str;
    }

    public static String dfs(TreeNode root, String str){
        if(root == null) return str+("#,");
        str = str + (root.val)+",";
        str = dfs(root.left, str);
        str = dfs(root.right, str);
        
        return str;
    }

    // Decodes your encoded data to tree.
    int i = 0;
    public TreeNode deserialize(String data) {
        if(data.charAt(i) == '#'){
            i+= 2; 
            return null;
        }
        int start = i;
        while(data.charAt(i) != ','){
            i++;
        }

        String val = data.substring(start, i);
        i++;
        
        if(val.length() == 0) return null;
        TreeNode curr = new TreeNode (Integer.parseInt(val));
        curr.left = deserialize(data);
        curr.right = deserialize(data);

        return  curr;
    }
}