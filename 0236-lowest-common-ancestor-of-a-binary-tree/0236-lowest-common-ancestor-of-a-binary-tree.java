/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p) return p;
        if(root == q) return q;
        if(root == null) return null;
        //1. search and traverse the tree
        //2. if p==root return root(left)
        //3. if q==root return root(right)
        //4. if both left and right != null return root(this is the LCA)
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //if both return not null, that means child must be
        // found and contained in one of the subtree.
        if(left != null && right != null) return root;
        if(left == null) return right;
        else return left;
    }
}