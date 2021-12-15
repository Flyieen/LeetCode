/*
 * @lc app=leetcode.cn id=530 lang=java
 *
 * [530] 二叉搜索树的最小绝对差
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

//采用中序遍历
/**
 * 188/188 cases passed (0 ms)
    Your runtime beats 100 % of java submissions
    Your memory usage beats 99.82 % of java submissions (37.5 MB)
 */
class Solution {
    int diff = 0;
    int value = -1;
    public int getMinimumDifference(TreeNode root) {
        calDiff(root);
        return diff;
    }
    public void calDiff(TreeNode root){
        if(root == null){
            return;
        }
        calDiff(root.left);
        if(value < 0){
            value = root.val;
        }
        if(diff == 0){
            diff = root.val - value;
        }
        diff = Math.min(diff, root.val - value );
        value = root.val;
        calDiff(root.right);
    }
}
// @lc code=end

