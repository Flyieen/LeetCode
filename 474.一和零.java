/*
 * @lc app=leetcode.cn id=474 lang=java
 *
 * [474] 一和零
 */

// @lc code=start
class Solution {
    /*
    将问题转化为背包问题：
    将[0...i]的放入m 和n的背包中，最多能放多少
    字符串是商品，所以要先遍历商品，再遍历背包
    动态规划：
    1、dp[i][j]：最多有i个0和j个1的strs的最大子集的大小为dp[i][j]。
    2、转移方程：max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
    dp[i][j] 可以由前一个strs里的字符串推导出来，
    strs里的字符串有zeroNum个0，oneNum个1。
    dp[i][j] 就可以是 dp[i - zeroNum][j - oneNum] + 1。
    然后我们在遍历的过程中，取dp[i][j]的最大值。
    3、base case：dp[0][0] = 0

    71/71 cases passed (24 ms)
    Your runtime beats 99.54 % of java submissions
    Your memory usage beats 67.04 % of java submissions (37.8 MB)
    */
    public int findMaxForm(String[] strs, int m, int n) {
        //dp[i][j]表示i个0和j个1时的最大子集
        int[][] dp = new int[m + 1][n + 1];
        int oneNum, zeroNum;
        for (String str : strs) {
            oneNum = 0;
            zeroNum = 0;
            for (char ch : str.toCharArray()) {
                if (ch == '0') {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }
            //倒序遍历
            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
// @lc code=end

