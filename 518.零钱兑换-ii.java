/*
 * @lc app=leetcode.cn id=518 lang=java
 *
 * [518] 零钱兑换 II
 */

// @lc code=start
class Solution {
    /*
    将问题转换为完全背包问题：商品有无限，求出刚好装满背包的方式
    总数
    动态规划五部：
    1、dp[j]：表示容量为j时用[0...i]商品刚好装满背包的方式总数
    2、转移方程：dp[j] = Math.max(dp[j], dp[j-coins[i]]+1)
    3、base case:dp[0]= 1

    28/28 cases passed (2 ms)
    Your runtime beats 100 % of java submissions
    Your memory usage beats 92.74 % of java submissions (35.6 MB)
    */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int i = 0; i < coins.length; i++){
            for(int j = coins[i]; j <= amount; j++){
                //旧的dp[j]就是不考虑i物品的能凑出的方式
                //在考虑i物品时，有多少种方法凑出j-coins[i]，
                //就有多少方法凑出j
                dp[j] += dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}
// @lc code=end

