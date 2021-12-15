/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    //贪心算法：找最小和最大值
    /*211/211 cases passed (2 ms)
    Your runtime beats 91.65 % of java submissions
    Your memory usage beats 91.83 % of java submissions (51 MB)
    */
    // public int maxProfit(int[] prices) {
    //     // 找到一个最小的购入点
    //     int low = Integer.MAX_VALUE;
    //     // res不断更新，直到数组循环完毕
    //     int res = 0;
    //     for(int i = 0; i < prices.length; i++){
    //         low = Math.min(prices[i], low);
    //         res = Math.max(prices[i] - low, res);
    //     }
    //     return res;
    // }

    /*
    动态规划：
    1、dp[i][0] 表示第i天持有股票所得最多现金 
    2、转移方程：
    如果第i天持有股票即dp[i][0]， 那么可以由两个状态推出来

    第i-1天就持有股票，那么就保持现状，所得现金就是昨天持有
    股票的所得现金 即：dp[i - 1][0]
    第i天买入股票，所得现金就是买入今天的股票后
    所得现金即：-prices[i]
    那么dp[i][0]应该选所得现金最大的，
    所以dp[i][0] = max(dp[i - 1][0], -prices[i]);

    如果第i天不持有股票即dp[i][1]， 也可以由两个状态推出来

    第i-1天就不持有股票，那么就保持现状，所得现金就是昨天不
    持有股票的所得现金 即：dp[i - 1][1]
    第i天卖出股票，所得现金就是按照今天股票佳价格卖出后所得现金
    即：prices[i] + dp[i - 1][0]
    同样dp[i][1]取最大的，
    dp[i][1] = max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
    3、base case：dp[0][0] -= prices[0], 
    dp[0][1]表示第0天不持有股票，不持有股票那么现金就是0，所以dp[0][1] = 0;

    211/211 cases passed (5 ms)
    Your runtime beats 16.31 % of java submissions
    Your memory usage beats 94.77 % of java submissions (50.8 MB)
    */
    public int maxProfit(int[] prices) {
        if(prices.length == 1){
            return 0;
        }
        //dp只需要存两个值，所以可以用滚动数组
        int n = prices.length;
        int dp0 = -prices[0];
        int dp1 = 0;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < 2; j++){
                if(j == 0){
                    dp0 = Math.max(dp0, -prices[i]);
                }
                if(j == 1){
                    dp1 = Math.max(dp1, prices[i] + dp0);
                }
            }
        }
        return dp1;
    }
    
}
// @lc code=end

