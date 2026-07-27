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
 class Result{
    int val;
    Result(int val){
        this.val = val;
    }        
}
class Solution {
    int i=1;
    Result x;
    public int kthSmallest(TreeNode root, int k) {
         inorder(root, k );
         return x.val;
    }
    void inorder(TreeNode root,int k){
        if(root == null) return;
        inorder(root.left,k);
        if(i++ == k)  x = new Result(root.val);
        inorder(root.right,k);
    }
}