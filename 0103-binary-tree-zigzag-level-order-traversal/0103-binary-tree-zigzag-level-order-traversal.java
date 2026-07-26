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
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return new ArrayList<>();
        q.add(root);
        int l = 1;
        while(!q.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode currNode = q.poll();
                if(currNode != null){
                    level.add(currNode.val);
                }
                if(currNode.left != null) q.add(currNode.left);
                if(currNode.right!= null) q.add(currNode.right);
            }
            if(l%2==0){
            Collections.reverse(level); }
            ans.add(level);
            l++;
        }
        return ans;
    }
}