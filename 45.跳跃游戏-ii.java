/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    /*解题思路：最值问题使用动态规划算法
    1、dp: 表示调到最后最少需要花多少步
    2、状态转移方程：
    （1）如何可以一步跳过去(index + nums[index] >= nusm.length-1)：dp[i] = 1
    （2）不可以一步跳过去：找到能跳到位置，然后取其中最小值 + 1
    3、base case:nums[nums.length - 2] = 1
    空间优化：直接在nums上修改

    106/106 cases passed (31 ms)
    Your runtime beats 22.34 % of java submissions
    Your memory usage beats 35.89 % of java submissions (39.3 MB)
    */
    // public int jump(int[] nums) {
    //     if(nums.length == 1){
    //         return 0;
    //     }
    //     nums[nums.length-2] = 1;
    //     for(int i = nums.length - 3; i >= 0; i--){
    //         if(nums[i]+i >= nums.length-1){
    //             nums[i] = 1;
    //             continue;
    //         }
    //         int min = nums[i+1];
    //         for(int j = i+1; j <= i+nums[i]; j++){
    //             if(min > nums[j]){
    //                 min = nums[j]; 
    //             }
    //         }
    //         nums[i] = min + 1;
    //     }
    //     return nums[0];
    // }

    /*
    更快的动态规划写法
    106/106 cases passed (2 ms)
    Your runtime beats 48.44 % of java submissions
    Your memory usage beats 85.09 % of java submissions (38.8 MB)
     */
    // public int jump(int[] nums) {
    //     if(nums.length == 1){
    //         return 0;
    //     }
    //     int n = nums.length;
    //     int[] dp = new int[n];
    //     int start = 0;
    //     for(int i = 1; i<n; ++i){
    //         for(int j = start; j<i; ++j){
    //             if(j+nums[j]>=i){
    //                 start = j;
    //                 dp[i] = dp[j] + 1;
    //                 break;
    //             }
    //         }
    //     }
    //     return dp[n-1];
    // }
    
    /*
    贪心算法：每次在上次能跳到的范围（end）内选择一个能跳的最远的
    位置（也就是能跳到max_far位置的点）作为下次的起跳点 ！

    106/106 cases passed (1 ms)
    Your runtime beats 99.15 % of java submissions
    Your memory usage beats 21.44 % of java submissions (39.3 MB)
    */
    public int jump(int[] nums) {
        int max_far = 0;// 目前能跳到的最远位置
        int step = 0;   // 跳跃次数
        int end = 0;    // 上次跳跃可达范围右边界（下次的最右起跳点）
        for (int i = 0; i < nums.length - 1; i++){
            max_far = Math.max(max_far, i + nums[i]);
            // 到达上次跳跃能到达的右边界了
            if (i == end){
                end = max_far;  // 目前能跳到的最远位置变成了下次起跳位置的有边界
                step++;         // 进入下一次跳跃
            }
        }
        return step;
    }
}
// @lc code=end

