/*
 * @lc app=leetcode.cn id=264 lang=java
 *
 * [264] 丑数 II
 */

// @lc code=start
class Solution {
    /*解题思路：动态规划+最小堆
    596/596 cases passed (2 ms)
    Your runtime beats 99.57 % of java submissions
    Your memory usage beats 94.38 % of java submissions (37.2 MB)
     */
    public int nthUglyNumber(int N) {
        if (N <= 6){
            //当n<=6时，第n个丑数就是n
            return N;
        }
        int i2 = 0, i3 = 0, i5 = 0;
        int[] dp = new int[N];
        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            int next2 = dp[i2] * 2, next3 = dp[i3] * 3, next5 = dp[i5] * 5;
            dp[i] = Math.min(next2, Math.min(next3, next5));
            if (dp[i] == next2)
                i2++;
            if (dp[i] == next3)
                i3++;
            if (dp[i] == next5)
                i5++;
        }
        return dp[N - 1];
    }
}
// @lc code=end

