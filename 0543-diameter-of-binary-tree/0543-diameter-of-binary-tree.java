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
     int d = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        f(root);
        return d;
    }
    public int f(TreeNode root){
        if(root == null) return 0;

        int leftHeight = f(root.left);
        int rightHeight = f(root.right);

        d = Math.max(d, leftHeight + rightHeight); //at each node we cal this to check if the current path is highest

        return 1 + Math.max(leftHeight, rightHeight);
    }
}