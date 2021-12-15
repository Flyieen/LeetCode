import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
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
从上到下，用前序遍历
遍历整棵树且不用处理递归返回值，所以递归函数没有返回值
*/

/*
Your runtime beats 100 % of java submissions
Your memory usage beats 26.89 % of java submissions (38.4 MB)
*/
// class Solution {
//     boolean flag = false;

//     public boolean hasPathSum(TreeNode root, int targetSum) {
//         countSum(root, targetSum, 0);
//         return flag;
//     }

//     public void countSum(TreeNode root, int targetSum, int sum){
//         if(root == null){
//             return;
//         }
//         int smallSum = sum;
//         smallSum += root.val;
//         if(root.left == null && root.right == null && smallSum == targetSum){
//             flag = true;
//             return;
//         }
//         countSum(root.left, targetSum, smallSum);
//         countSum(root.right, targetSum, smallSum);
//     }
// }

/*
向下遍历（前序遍历）过程中 targetNum - root.val，到叶子节点看target==0
因为这里需要处理返回的布尔值，所以递归函数需要返回值

117/117 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 43.66 % of java submissions (38.4 MB)
*/
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        targetSum -= root.val;
        // 叶子结点
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }
        if (root.left != null) {
            boolean left = hasPathSum(root.left, targetSum);
            if (left) {// 已经找到
                return true;
            }
        }
        if (root.right != null) {
            boolean right = hasPathSum(root.right, targetSum);
            if (right) {// 已经找到
                return true;
            }
        }
        return false;
    }
}


// @lc code=end

