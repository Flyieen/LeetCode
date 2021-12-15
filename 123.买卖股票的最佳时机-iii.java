/*
 * @lc app=leetcode.cn id=123 lang=java
 *
 * [123] 买卖股票的最佳时机 III
 */

// @lc code=start
class Solution {
    /*
    贪心解法：我们可以看做两天之间的利润，找出最大和第二大的两个
    利润，然后将这两个利润相加然后返回
    注意，3，4，7的利润为1，3，则利润是1+3 = 4，注意当正值连在
    一起的时候要累加
    */

    //这个思想是错的，[1,2,4,2,5,7,2,4,9,0]会出问题，
    //answer = 12， expected answer：13
    // public int maxProfit(int[] prices) {
    //     int temp = 0;//临时存利润
    //     int maxNumber = 0;
    //     int secondNumber = 0;
    //     //用来判断正值是否连续
    //     int preNumber = 0;
    //     for(int i = 1; i < prices.length; i++){
    //         temp = prices[i] - prices[i-1];
    //         if(temp >= 0){
    //             preNumber += temp;
    //         }else{
    //             if(preNumber > maxNumber){
    //                 secondNumber = maxNumber;
    //                 maxNumber = preNumber;
    //             }else if(preNumber > secondNumber){
    //                 secondNumber = preNumber;
    //             }
    //             preNumber = 0;
    //         }
    //     }

            //如果temp一直不小于0，就需要这里特殊操作一下
    //     if(preNumber > 0 && maxNumber == 0){
    //         return preNumber;
    //     }

            //如果最后一个值是正的，就没有并入，这里并入
    //     if(preNumber > maxNumber){
    //         secondNumber = maxNumber;
    //         maxNumber = preNumber;
    //     }else if(preNumber > secondNumber){
    //         secondNumber = preNumber;
    //     }
        
    //     return maxNumber + secondNumber;
    // }

    /*动态规划：
    1、dp：一天一共就有五个状态，
    0. 没有操作
    1：第一次买入
    2：第一次卖出
    3：第二次买入
    4：第二次卖出
    dp[i][j]中 i表示第i天，j为 [0 - 4] 五个状态，
    dp[i][j]表示第i天状态j所剩最大现金。
    2、转移方程：
    需要注意：dp[i][1]，表示的是第i天，买入股票
    的状态，并不是说一定要第i天买入股票，这是很多
    同学容易陷入的误区。

    达到dp[i][1]状态，有两个具体操作：

    操作一：第i天买入股票了，那么dp[i][1] = dp[i-1][0] - prices[i]
    操作二：第i天没有操作，而是沿用前一天买入的状态，即：dp[i][1] = dp[i - 1][1]
    那么dp[i][1]究竟选 dp[i-1][0] - prices[i]，还是dp[i - 1][1]呢？

    一定是选最大的，所以 dp[i][1] = max(dp[i-1][0] - prices[i], dp[i - 1][1]);

    同理dp[i][2]也有两个操作：

    操作一：第i天卖出股票了，那么dp[i][2] = dp[i - 1][1] + prices[i]
    操作二：第i天没有操作，沿用前一天卖出股票的状态，即：dp[i][2] = dp[i - 1][2]
    所以dp[i][2] = max(dp[i - 1][1] + prices[i], dp[i - 1][2])

    同理可推出剩下状态部分：

    dp[i][3] = max(dp[i - 1][3], dp[i - 1][2] - prices[i]); 
    dp[i][4] = max(dp[i - 1][4], dp[i - 1][3] + prices[i]);

    3、base case：
    dp[0][0] = 0;
    dp[0][1] = -prices[0];
    dp[0][2] = 0;
    dp[0][3] = -prices[0];
    dp[0][4] = 0;

    214/214 cases passed (6 ms)
    Your runtime beats 62.49 % of java submissions
    Your memory usage beats 76.58 % of java submissions (50.8 MB)
    */
    public int maxProfit(int[] prices) {
        int[] dp = new int[4]; 
        // 存储两次交易的状态就行了
        // dp[0]代表第一次交易的买入
        dp[0] = -prices[0];
        // dp[1]代表第一次交易的卖出
        dp[1] = 0;
        // dp[2]代表第二次交易的买入
        dp[2] = -prices[0];
        // dp[3]代表第二次交易的卖出
        dp[3] = 0;

        //直接就是第二次了
        for(int i = 1; i <= prices.length; i++){
            /*
            dp[1] = max(dp[1], dp[0] - prices[i]); 如果dp[1]取dp[1]，即保持
            买入股票的状态，那么 dp[2] = max(dp[2], dp[1] + prices[i]);中
            dp[1] + prices[i] 就是今天卖出。
            如果dp[1]取dp[0] - prices[i]，今天买入股票，那么
            dp[2] = max(dp[2], dp[1] + prices[i]);中的dp[1] + prices[i]
            相当于是尽在再卖出股票，一买一卖收益为0，对所得现金没有影响。
            相当于今天买入股票又卖出股票，等于没有操作，保持昨天卖出股票的状态了。
            */


            // 要么保持不变，要么没有就买，有了就卖
            dp[0] = Math.max(dp[0], -prices[i-1]);
            dp[1] = Math.max(dp[1], dp[0]+prices[i-1]);
            // 这已经是第二次交易了，所以得加上前一次交易卖出去的收获
            dp[2] = Math.max(dp[2], dp[1]-prices[i-1]);
            dp[3] = Math.max(dp[3], dp[2]+ prices[i-1]);
        }
        return dp[3];
    }
}
// @lc code=end

