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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        addList(root,result,0);

        return result;
    }

    private void addList(TreeNode root, List<List<Integer>> result, int height){
        if(root == null){
            return ;
        }
        if(result.size()==height){
            result.add(new ArrayList<Integer>());
        }
        result.get(height).add(root.val);
        addList(root.left,result,height+1);
        addList(root.right,result,height+1);
    }
}
