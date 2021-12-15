/*
 * @lc app=leetcode.cn id=671 lang=java
 *
 * [671] 二叉树中第二小的节点
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
/**
 * 39/39 cases passed (0 ms)
    Your runtime beats 100 % of java submissions
    Your memory usage beats 80.52 % of java submissions (35.5 MB)
 */
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return -1;
        }
        //根节点是最小的，因此左子树和右子树的最小值就是想要的结果
        int leftVal = root.left.val;
        int rightVal = root.right.val;
        if (leftVal == root.val) leftVal = findSecondMinimumValue(root.left);
        if (rightVal == root.val) rightVal = findSecondMinimumValue(root.right);
        //左右都有个最小值
        if (leftVal != -1 && rightVal != -1) return Math.min(leftVal, rightVal);
        //左边有个最小值，右边没有
        if (leftVal != -1) return leftVal;
        //左边没有最小值，直接返回右树最小值
        return rightVal;
    }
    
}
// @lc code=end

