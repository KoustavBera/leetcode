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
    public boolean isBalanced(TreeNode root) {
        // 1. traverse left sub trees
        // 2. find left height
        // 3. do same for right
        // 4. if the height diff > 1 then not balanced
        return f(root) != -1;
    }
    int f(TreeNode root){
        if(root == null ) return 0;
        int l = f(root.left);
        if(l==-1) return -1;
        int r = f(root.right);
        if(r==-1) return -1;

        //now cal height diff
        if(Math.abs(l - r) > 1) return -1;
        return 1 + Math.max(l, r);
    }
}