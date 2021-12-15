/*
 * @lc app=leetcode.cn id=494 lang=java
 *
 * [494] 目标和
 */

// @lc code=start
class Solution {
    /*
    将问题转化为背包问题：
    1、本质上就是讲nums数组分成两类A和B，A和B的关系是A-B = target
    A - (sum-A)= target -> A = (sum + target) / 2
    本题就是找出和为A的组合
    动态规划五步：
    1、dp[i][j]；使用二维dp数组来求解本题，dp[i][j]：使用下标为
    [0, i]的nums[i]能够凑满j（包括j）这么大容量的包，有dp[i][j]
    种方法。
    dp[j]
    2、转移方程：dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]]
    因为考虑dp[i-1][j]，对于【0，i-1】有dp[i-1][j]种方法，
    如果加入i的话，那么有dp[i-1][j-nums[i-1]]种方法，
    所以两种相加即可
    降低到一维：dp[j] += dp[j-nums[i]]
    3、base case：dp[0] = 1;装满容量为0的背包，有1种方法，就是装0件物品
    4、遍历方向：j要倒序

    时间复杂度：O(n*(sum+target))
    空间复杂度：O(sum+target)
    139/139 cases passed (2 ms)
    Your runtime beats 94.63 % of java submissions
    Your memory usage beats 36.97 % of java submissions (36.2 MB)
    */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if ((target + sum) % 2 != 0) {
            //如果不能整除，则说明不存在方法能使得最终目标和为target
            return 0;
        }
        int A = (sum + target) / 2;
        if(A < 0){
            //A可能是负的，转成正的才能用背包
            A = -A;
        }
        int[] dp = new int[A+1];
        dp[0] = 1;
        for(int i = 0; i < nums.length; i++){
            for(int j = A; j >= nums[i]; j--){
                dp[j] += dp[j-nums[i]];
            }
        }
        return dp[A];
    }
}
// @lc code=end

