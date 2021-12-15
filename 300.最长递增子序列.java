/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

// @lc code=start
class Solution {
    /*解题思路：
    1.确定状态：加上最后一个值即构成最长子序列，用res记录最长的
    dp[i] 表示以nums[i]为结尾的最长递增子序列
    2.转移方程： dp[i] = Math.max(nums[i] > nums[j] ? dp[j] + 1 : 1, dp[i]);
    3.初始条件：dp[0] = 1;
    时间复杂度O(n^2)，空间复杂度O(n)

    54/54 cases passed (77 ms)
    Your runtime beats 5.05 % of java submissions
    Your memory usage beats 65.7 % of java submissions (38 MB)
    */
    // public int lengthOfLIS(int[] nums) {
    //     int[] dp = new int[nums.length];
    //     dp[0] = 1;
    //     int res = dp[0];
    //     for(int i = 1; i < nums.length; i++){
    //         for(int j = 0; j < i; j++){
    //             dp[i] = Math.max(nums[i] > nums[j] ? dp[j] + 1 : 1, dp[i]);
    //         }
    //         res = Math.max(res, dp[i]);
    //     }
    //     return res;
    // }

    /*
    还可以使用二分搜索，时间复杂度可以降低到O(nlog(n))
    但是一般很难想到这个解法，普通人能想到动态规划就不错了
    */
}
// @lc code=end

