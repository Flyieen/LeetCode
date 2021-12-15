/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */

// @lc code=start
class Solution {
    /*
    1.确定状态：最后一个最大，前面的应当是正贡献
    2.转移方程：dp[i] = Math.max(0, dp[i-1]) + nums[i]; dp表示连续子数组的和；
    3.初始条件：dp[0] = nums[0]

    优化：可以在原数组上修改

    Your runtime beats 35.13 % of java submissions
    Your memory usage beats 7.64 % of java submissions (48.8 MB)
    */
    public int maxSubArray(int[] nums) {
        int res = nums[0];//res记录最大值
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i-1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}
// @lc code=end

