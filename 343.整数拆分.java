/*
 * @lc app=leetcode.cn id=343 lang=java
 *
 * [343] 整数拆分
 */

// @lc code=start
class Solution {
    /*动态规划
    如果2应该分成1*1，那么3就应该是2*1
    1、dp：正整数i的最大乘积
    2、转移方程：dp[i]= Math.max(dp[i],Math.max(j*dp[i-j],j*(i-j)))
    3、base case：dp[1] = 1，1的最大乘积为1

    50/50 cases passed (1 ms)
    Your runtime beats 72.42 % of java submissions
    Your memory usage beats 95.63 % of java submissions (34.9 MB)
    */
    // public int integerBreak(int n) {
    //     int[] dp = new int[n + 1];
    //     dp[1] = 1;
    //     for (int i = 2; i <= n; i++) {
    //         for (int j = 1; j <= i - 1; j++) {
    //             dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
    //         }
    //     }
    //     return dp[n];
    // }

    /*① 当所有拆分出的数字相等时，乘积最大。② 最优拆分数字为 3
    最优： 3。把数字 n 可能拆为多个因子3 ，余数可能为 0,1,2 三种情况。
    次优： 2。若余数为 2 ；则保留，不再拆为1+1 。
    最差： 1。若余数为 1 ；则应把一份 3 + 1替换为2+2，
    因为 2×2 > 3×1

    50/50 cases passed (0 ms)
    Your runtime beats 100 % of java submissions
    Your memory usage beats 35.21 % of java submissions (35.2 MB)
    算法参考：https://leetcode-cn.com/problems/integer-break/solution/343-zheng-shu-chai-fen-tan-xin-by-jyd/
    */
    public int integerBreak(int n) {
        //当n<=3时，直接返回
        if(n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        //可以被三整除，所以直接相乘即可
        if(b == 0) return (int)Math.pow(3, a);
        //除3余1，把3+1改为2*2，所以a要让一个3出来，和1组成乘积4
        if(b == 1) return (int)Math.pow(3, a - 1) * 4;
        //除3余2，则直接3^a*2即可
        return (int)Math.pow(3, a) * 2;
    }

    
}
// @lc code=end

