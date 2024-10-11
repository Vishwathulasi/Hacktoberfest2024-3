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
    // Variable to store the maximum path sum, initialized to the smallest possible value
    int sum = Integer.MIN_VALUE;

    // Method to return the maximum path sum of the binary tree
    public int maxPathSum(TreeNode root) {
        // Base case: if the tree has only a single node, return its value
        if (root.left == null && root.right == null)
            return root.val;

        // Find the maximum path sum starting from the root
        find(root);

        // Return the maximum path sum
        return sum;
    }

    // Helper method to recursively calculate the maximum path sum
    public int find(TreeNode root) {
        // Base case: if the node is null, return 0 (no contribution to the path sum)
        if (root == null)
            return 0;

        // Recursively calculate the maximum path sum from the left subtree
        // Use Math.max(0, ...) to ignore negative contributions (subtree paths that reduce the sum)
        int lr = Math.max(0, find(root.left));

        // Recursively calculate the maximum path sum from the right subtree, similarly ignoring negative values
        int rh = Math.max(0, find(root.right));

        // Calculate the total path sum passing through the current node (including left and right subtree paths)
        int max = lr + rh + root.val;

        // Update the overall maximum path sum if the current path sum is greater than the previously stored sum
        if (max >= sum) {
            sum = max;
        }

        // Return the maximum sum of a path that can be extended to the parent node
        // We can either extend the left or the right subtree, whichever is larger
        int l1 = lr + root.val;
        int l2 = rh + root.val;
        if (l1 >= l2)
            return l1;

        // If the right subtree gives a larger path sum, return that value
        return l2;
    }
}
