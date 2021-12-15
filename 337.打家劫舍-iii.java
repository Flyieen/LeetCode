/*
 * @lc app=leetcode.cn id=337 lang=java
 *
 * [337] 打家劫舍 III
 */

// @lc code=start
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
    /*
    3.状态标记递归
    采用后序遍历

    
    不偷：Max(左孩子不偷，左孩子偷) + Max(又孩子不偷，右孩子偷)
    root[0] = Math.max(rob(root.left)[0], rob(root.left)[1]) +
    Math.max(rob(root.right)[0], rob(root.right)[1])
    偷：左孩子不偷+ 右孩子不偷 + 当前节点偷
    root[1] = rob(root.left)[0] + rob(root.right)[0] + root.val;

    124/124 cases passed (0 ms)
    Your runtime beats 100 % of java submissions
    Your memory usage beats 73.64 % of java submissions (37.9 MB)
    */
    public int rob(TreeNode root) {
        int[] res = robAction1(root);
        return Math.max(res[0], res[1]);
    }

    int[] robAction1(TreeNode root) {
        int res[] = new int[2];
        if (root == null)
            return res;

        int[] left = robAction1(root.left);
        int[] right = robAction1(root.right);

        //当前节点不偷
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //当前节点偷
        res[1] = root.val + left[0] + right[0];
        return res;
    }
}
// @lc code=end

