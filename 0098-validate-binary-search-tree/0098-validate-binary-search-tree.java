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
    public boolean isValidBST(TreeNode root) {
       return validateBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    private boolean validateBST(TreeNode root, long max, long min){
        //a tree with no node is a valid BST
        if(root == null) return true;

        //check if the current node violates the 
        //squeezed boundaries and return false
        if(root.val <= min || root.val >= max)
        return false;

        //Recurse left except the current max with me the curr val
        boolean left = validateBST(root.left, root.val, min);

        //Recurse right except the current min with me the curr val
        boolean right = validateBST(root.right, max, root.val );

        //check if both left and right subtree 
        //are valid
        return left && right;

    }

}