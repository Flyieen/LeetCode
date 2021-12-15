import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
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

/*
    Your runtime beats 100% of java submissions
    Your memory usage beats 92.16% of java submissions(38.2MB)
  */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return countLevels(root) >= 0;
    }

    private int countLevels(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = countLevels(root.left);
        int right = countLevels(root.right);
        if(Math.abs(left-right) > 1 || left == -1 || right == -1){
            return -1;
        }else {
            return Math.max(left, right) + 1;
        }
    }
}
// @lc code=end

