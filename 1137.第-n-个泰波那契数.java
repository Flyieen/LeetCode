/*
 * @lc app=leetcode.cn id=1137 lang=java
 *
 * [1137] 第 N 个泰波那契数
 */

// @lc code=start
class Solution {
    /*
    39/39 cases passed (0 ms)
    Your runtime beats 100 % of java submissions
    Your memory usage beats 86.98 % of java submissions (35 MB)
    */
    public int tribonacci(int n) {
        if(n == 0){
            return 0;
        }
        int[] dp = new int[3];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3; i <= n; i++){
            int temp = dp[0] + dp[1] + dp[2];
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = temp;
        }
        return dp[2];
    }
}
// @lc code=end

