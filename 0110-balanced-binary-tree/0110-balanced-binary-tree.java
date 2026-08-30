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
        return height(root) != -1;
    }
    public static int height(TreeNode root){
        if(root == null) return 0;

        //calculate left tree
        int leftHeight = height(root.left);
        //check right tree
        int rightHeight = height(root.right);
        if(leftHeight == -1){
            return -1;
        }

        

        if(rightHeight == -1){
            return -1;
        }

        if(Math.abs(leftHeight - rightHeight)>1){
            return -1;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }
}