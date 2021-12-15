import sun.text.normalizer.UCharacter.NumericType;

/*
 * @lc app=leetcode.cn id=1049 lang=java
 *
 * [1049] 最后一块石头的重量 II
 */

// @lc code=start
class Solution {
    /*
    将问题改为背包问题：
    本题其实就是尽量让石头分成重量相同的两堆，相撞之后剩下的石头
    最小，这样就化解成01背包问题了
    所以题目转为为求大小sum/2的背包最多能装多少重量石头
    动态规划五部：
    1、dp[j]；背包重量为j时i个石头的时候最多能装多少重量；
    2、转移方程：
    if(j - nums[i] >=0){
        //倒序遍历
        dp[j] = Math.max(dp[j],dp[j-nums[i]]+nums[i])
    }
    3、base case:dp[0] = 0;

    87/87 cases passed (3 ms)
    Your runtime beats 83.91 % of java submissions
    Your memory usage beats 72.83 % of java submissions (35.7 MB)
    */
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int stone : stones){
            sum += stone;
        }
        int target = sum / 2;
        int[] dp = new int[target+1];
        for(int i = 0; i < stones.length; i++){
            for(int j = target; j >= stones[i]; j--){
                dp[j] = Math.max(dp[j], dp[j-stones[i]]+stones[i]);
            }
        }
        //得到的是一个target能得到的最大的值dp[target]，那么另外一个值就是
        //sum-dp[target]，所以两个值的差为(sum - dp[target]) - dp[target]
        return sum - 2*dp[target];
    }
}
// @lc code=end

