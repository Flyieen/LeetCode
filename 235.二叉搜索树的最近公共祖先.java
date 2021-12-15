/*
 * @lc app=leetcode.cn id=235 lang=java
 *
 * [235] 二叉搜索树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
27/27 cases passed (7 ms)
Your runtime beats 8.91 % of java submissions
Your memory usage beats 48.47 % of java submissions (39.3 MB)
 */
// class Solution{
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
//         if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
//         return root;
//     }
// }

/**
27/27 cases passed (5 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 98.6 % of java submissions (38.8 MB)
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //如果小于等于0，说明p和q位于root的两侧，直接返回即可
    if ((root.val - p.val) * (root.val - q.val) <= 0){
        return root;
    }
    //否则，p和q位于root的同一侧，就继续往下找
    return lowestCommonAncestor(p.val < root.val ? root.left : root.right, p, q);
    }
}
// @lc code=end

