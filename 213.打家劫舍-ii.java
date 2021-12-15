/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
class Solution {
    /*
    分两次完成：
    1、第一次不包括最后一个遍历
    2、第二次不包括第一个进行遍历

    75/75 cases passed (0 ms)
    Your runtime beats 100 % of java submissions
    Your memory usage beats 85.58 % of java submissions (35.6 MB)
    */
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        return Math.max(robSubNums(nums, 0, nums.length-2),
                        robSubNums(nums, 1, nums.length-1));
    }

    private int robSubNums(int[] nums, int start, int end){
        int x = 0, y = 0, z = 0;
        for (int i = start; i <= end; i++) {
            y = z;
            z = Math.max(y, x + nums[i]);
            x = y;
        }
        return z;
    }
}
// @lc code=end

