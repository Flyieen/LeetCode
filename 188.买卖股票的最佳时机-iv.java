/*
 * @lc app=leetcode.cn id=188 lang=java
 *
 * [188] 买卖股票的最佳时机 IV
 */

// @lc code=start
class Solution {
    /*
    参考买卖股票的最佳时间Ⅲ写出结果
    如果k等于2，则有五种状态；状态数 = k * 2 + 1；
    0：无操作
    1：第一次买入
    2：第一次卖出
    3：第二次买入
    4：第二次卖出 2*k
    转移方程：
    dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);
    dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1]+prices[i]);
    dp[i][3] = Math.max(dp[i-1][3], dp[i-1][2]-prices[i]);
    dp[i][4] = Math.max(dp[i-1][4], dp[i-1][3]-prices[i]);


    dp[i][j] = j % 2 == 1 ? Math.max(dp[i-1][j], dp[i-1][0] - prices[i]):
                            Math.max(dp[i-1][j], dp[i-1][0] + prices[i]);

    dp[0][1] = -prices[0]
    dp[0][2] = 0
    dp[0][3] = -prices[0];


    211/211 cases passed (6 ms)
    Your runtime beats 57.32 % of java submissions
    Your memory usage beats 93.42 % of java submissions (35.9 MB)
    */
    public int maxProfit(int k, int[] prices) {
        if(prices.length == 0 || prices.length == 1){
            return 0;
        }
        int[] dp = new int[2*k + 1];
        for(int i = 1; i <= 2*k; i+=2){
            dp[i] = -prices[0];
        }
        for(int i = 1; i < prices.length; i++){
            for(int j = 1; j <= 2*k; j++){
                dp[j] = j % 2 == 1 ? Math.max(dp[j], dp[j-1] - prices[i]):
                            Math.max(dp[j], dp[j-1] + prices[i]);
            }
        }
        return dp[2*k];
    }
}
// @lc code=end

