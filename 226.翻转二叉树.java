import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=226 lang=java
 *
 * [226] 翻转二叉树
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
从上往下遍历，考虑采用前序遍历
不需要处理递归的返回值，所以递归函数不需要返回值
 */
class Solution {
    /*
    先交换深度低的节点，然后再交换高的即可完成
    77/77 cases passed (0 ms)
    Your runtime beats 100 % of java submissions
    Your memory usage beats 29.97 % of java submissions (35.9 MB)
     */
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode left = root.left;  // 后面的操作会改变 left 指针，因此先保存下来
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
    }
}
// @lc code=end

