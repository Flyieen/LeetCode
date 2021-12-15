import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 */

// @lc code=start
class Solution {
    /*
    完全背包问题：有不同的商品，用最少的商品可填满背包\
    动态规划：
    1、dp[j]:背包容量为j时用最少的商品填满，最少的数量
    2、转移方程：dp[j] = Math.min(dp[j], dp[j-i*i]+1);
    3、base case：dp[0] = 0 其他的都是最大值
    4、遍历方向：从前到后
    5、举例：12

    588/588 cases passed (27 ms)
    Your runtime beats 66.38 % of java submissions
    Your memory usage beats 39.29 % of java submissions (37.6 MB)

    */
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, (int)Math.pow(10, 4));
        dp[0] = 0;
        for(int i = 1; i <= Math.sqrt(n); i++){
            //注意这里i 要取能=Math.sqrt(n)，否则n=1就无法通过
            for(int j = i*i; j <= n; j++){
                dp[j] = Math.min(dp[j], dp[j-i*i]+1);
            }
        }
        return dp[n];
    }
}
// @lc code=end

