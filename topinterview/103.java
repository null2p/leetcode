/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        addLevel(root, 0, result);
        return result;
    }

    private void addLevel(TreeNode root, int level, List<List<Integer>> result){
        if(root==null){
            return ;
        }

        List<Integer> sameLevel;
        if(result.size() == level){
            sameLevel = new ArrayList<>();
            result.add(sameLevel);
        }
        else{
            sameLevel = result.get(level);
        }

        if(level%2 == 1){
            sameLevel.add(0,root.val);
        }
        else{
            sameLevel.add(root.val);
        }

        addLevel(root.left, level+1, result);
        addLevel(root.right, level+1, result);

    }
}
