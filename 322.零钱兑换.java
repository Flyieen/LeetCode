import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start
class Solution {
    /*
    背包问题：有如下商品，填满背包要最少要用多少商品
    而且是完全背包问题
    动态规划五部：
    1、dp[j]:背包容量为j刚好填满需要的硬币最少数量
    2、转移方程：dp[j] = Math.min(dp[j], dp[j-coins[i]]+1)
    3、base case：dp[0] = 0  其他值必须取很大的值，但是
    不能取Integer.Max_Value，因为+1会变成负的，然后导致最后的
    答案错误

    188/188 cases passed (11 ms)
    Your runtime beats 96.25 % of java submissions
    Your memory usage beats 84.74 % of java submissions (37.6 MB)
    */
    public int coinChange(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }
        int[] dp = new int[amount+1];
        Arrays.fill(dp, (int)Math.pow(10,4));
        dp[0] = 0;
        for(int i = 0; i < coins.length; i++){
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j-coins[i]]+1);
            }
        }
        return dp[amount] >= (int)Math.pow(10,4) ? -1: dp[amount];
    }
}
// @lc code=end

