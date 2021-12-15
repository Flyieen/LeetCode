/*
 * @lc app=leetcode.cn id=669 lang=java
 *
 * [669] 修剪二叉搜索树
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
78/78 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 6.83 % of java submissions (38.2 MB)
 */
class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null){
            return root;
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        // root在[low,high]范围内
        root.left = trimBST(root.left, low, high);//通过重新赋值删除结点
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
// @lc code=end

