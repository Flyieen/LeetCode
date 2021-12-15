/*
 * @lc app=leetcode.cn id=538 lang=java
 *
 * [538] 把二叉搜索树转换为累加树
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
//反着的中序遍历
/**
 * 215/215 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 67.61 % of java submissions (38.6 MB)
 */
class Solution {
    int num = 0;
    public TreeNode convertBST(TreeNode root) {
        reverseInorder(root);
        return root;
    }

    private void reverseInorder(TreeNode root) {
        if(root == null){
            return;
        }
        reverseInorder(root.right);
        num += root.val;
        root.val = num;
        reverseInorder(root.left);
    }
}

// @lc code=end

