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
    int i=1;
    int result = 0;
    public int kthSmallest(TreeNode root, int k) {
         inorder(root, k );
         return result;
    }
    void inorder(TreeNode root,int k){
        if(root == null) return;
        inorder(root.left,k);
        if(i++ == k){
              result = root.val ;
              return;
        } 
        inorder(root.right,k);
    }
}