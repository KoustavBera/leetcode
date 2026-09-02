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
        // tree [ null ] -> null
        // tree [ 3 4 null] -> 3 
        
       //case 1: root is null
       if(root == null){
        return null;
       }

       //case 2: root is either p or q
       if(root == p || root == q){
        return root; //then root is the LCA and the other one is just a subtree of root
       }

       //recurse left and right tree
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        

        //if left and right both are not null then -> root is the ancestor
        if(left != null && right != null) return root;

        //else if right is null then right is a subtree of left and vice-versa
        return left != null? left : right;
        

    }
}