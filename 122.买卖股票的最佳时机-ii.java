/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
    /*动态规划：
    贪心思想：我们可以将隔得较远的两天拆开
    例如：[7,1,5,3,6,4]
    1->6 可改为1->5 5->3 3->6
    利润分别为4，-2，3我们可以将正的取，负的不要
    局部最优累加起来就是全局最优

    200/200 cases passed (1 ms)
    Your runtime beats 99.67 % of java submissions
    Your memory usage beats 82.55 % of java submissions (38 MB)
    */
    // public int maxProfit(int[] prices) {
    //     int result = 0;
    //     for (int i = 1; i < prices.length; i++) {
    //         result += Math.max(prices[i] - prices[i - 1], 0);
    //     }
    //     return result;
    // }
    
    /*
    动态规划会比贪心更慢一点，同时也更难以理解：
    1、dp:dp[i][0] 表示第i天持有股票的所得最多现金。
    dp[i][1] 表示第i天不持有股票所得最多现金
    2、转移方程：
    持有股票现金：不限制交易次数，那么再次买股票时，要加上之前的收益
    持有股票有两种情况，之前买的没卖，所以是dp[i-1][0]
    之前买的卖了，今天买，那么就是dp[i-1][1] - prices[i-1]

    没有持有股票：
    1、前面买了，之前卖了，所以dp[i-1][1]
    2、前面买了，当天卖了：dp[i-1][1] = dp[i-1][0] + prices[i-1]

    dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i-1])
    不持有股票现金
    dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i-1]);
    3、base case：dp[0][0] = -prices[0];
    dp[0][1] = 0;

    200/200 cases passed (3 ms)
    Your runtime beats 22.63 % of java submissions
    Your memory usage beats 98.97 % of java submissions (37.6 MB)
     */
    public int maxProfit(int[] prices) {
        int[] dp = new int[2];
        // 0表示持有，1表示卖出
        dp[0] = -prices[0];
        dp[1] = 0;
        for(int i = 1; i <= prices.length; i++){
            // 前一天持有; 既然不限制交易次数，那么再次买股票时，要加上之前的收益
            dp[0] = Math.max(dp[0], dp[1] - prices[i-1]);
            // 前一天卖出; 或当天卖出，当天卖出，得先持有
            dp[1] = Math.max(dp[1], dp[0] + prices[i-1]);
        }
        return dp[1];
    }
}
// @lc code=end

