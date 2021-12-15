/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Solution {
    /*解题思路
    先考虑递归，nums[0...]有两种情况
    抢：nums[0...] = nums[2...] + nums[0]
    不抢：nums[0...] = nums[1...]
    可以使用递归，反过来
    但是用递归会出现测试案例超过时间限制，因为递归的太深了
     */
    // public int rob(int[] nums) {
    //     return dp(nums, 0);
    // }
    // private int dp(int[] nums, int start){
    //     if(start >= nums.length){
    //         return 0;
    //     }
    //     return Math.max(
    //         //抢这个屋子
    //         dp(nums, start+2)+nums[start], 
    //         //不抢这个屋子
    //         dp(nums, start+1));
    // }

    //因为递归存在太多重复计算，所以我们可以使用一个备忘录来记录重复计算
    // public int rob(int[] nums) {
    //     int n = nums.length;
    //     int[] dp = new int[n+1];
    //     dp[n] = 0;
    //     dp[n-1] = nums[n-1];
    //     for (int i = n-2; i >= 0; i--) {
    //         dp[i] = Math.max(dp[i+2]+nums[i], dp[i+1]);
    //     }
    //     return dp[0];
    // }
    
    //考虑我们只需要dp[i+1]和dp[i+2]，其实所以我们可以不建立一个数组
    /*
    68/68 cases passed (0 ms)
    Your runtime beats 100 % of java submissions
    Your memory usage beats 31.63 % of java submissions (35.9 MB)
    */
    public int rob(int[] nums) {
    
        int n = nums.length;
        // 记录 dp[i+1] 和 dp[i+2]
        int dp_i_1 = 0, dp_i_2 = 0;
        // 记录 dp[i]
        int dp_i = 0; 
        for (int i = n - 1; i >= 0; i--) {
            dp_i = Math.max(dp_i_1, nums[i] + dp_i_2);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i;
    }
}
// @lc code=end

