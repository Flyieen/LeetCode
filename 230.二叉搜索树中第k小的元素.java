/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第K小的元素
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

//中序遍历，第k个就是结果
/*
93/93 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 67.81 % of java submissions (38.2 MB)
 */
class Solution {
    int num = 0;
    int value = 0;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root,k);
        return value;
    }
    private void inOrder(TreeNode root,int k) {
        if(root ==null){
            return;
        }
        inOrder(root.left, k);
        if(++num == k){
            value = root.val;
        }
        inOrder(root.right, k);
    }
}
// @lc code=end

