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
    public List<Integer> rightSideView(TreeNode root) {
        // Edge case: empty tree → nothing to see from any side
        if (root == null) return new ArrayList<>();

        // Queue for BFS level-order traversal.
        // We use BFS because "right side view" = last visible node at each level,
        // and BFS naturally processes nodes level-by-level.
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        List<Integer> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            // Capture the number of nodes at the CURRENT level.
            // ⚠️ Important: we MUST store this before the for-loop,
            // because q.size() changes as we add children for the NEXT level.
            int size = q.size();

            // Process every node at this level
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                // Enqueue ALL children (standard BFS) — we need to see every node
                // at the next level to determine which one is rightmost.
                // Order matters: left first, then right → so the LAST node
                // polled in this level will be the rightmost one.
                if (curr.left != null)  q.add(curr.left);
                if (curr.right != null) q.add(curr.right);

                // The last node processed in this level is the one visible
                // from the right side (since we enqueue left→right).
                if (i == size - 1) {
                    ans.add(curr.val);
                }
            }
        }

        return ans;
    }
}