/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
class Solution {
    /* 动态规划五步：
    1、dp[i]：i个节点的二叉搜索树的总数
    2、转移方程：
    本质上我们可以认为二叉搜索树只有一种情况，就是右图紫色的样子
    左子树和右子树的节点数分别为j-1和i-j（相加为i-1）
    总个数就是左子树的总数乘以右子树个数然后相加
    有两种特殊情况就是左子树是空，则认为其等于1
    3、base case：dp[0] = 1
    4、遍历顺序：从前向后遍历
    时间复杂度：O(n^2)
    空间复杂度：O(n)
    19/19 cases passed (0 ms)
    Your runtime beats 100 % of java submissions
    Your memory usage beats 65.78 % of java submissions (35.1 MB)
    */
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                dp[i] += dp[j-1] * dp[i-j]; //为什么是乘，组合原理
                //特殊情况有两种，左子树为空树，右子树为空树
                //分别对应j-1 = 0 和 i-j = 0
            }
        }
        return dp[n];
    }
}
// @lc code=end

