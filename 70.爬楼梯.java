/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    /*
    1、确定状态：最后一步可以走两步或者走一步
    2. 转移方程：dp[n] = dp[n-1]+dp[n-2]
    3. 初始状态：dp[1] = 1 dp[2] = 2
    斐波那切数列方法
    45/45 cases passed (0 ms)
    Your runtime beats 100 % of java submissions
    Your memory usage beats 10.43 % of java submissions (35.3 MB)
    */
    // public int climbStairs(int n) {
    //     if (n == 0 || n == 1) {
    //         return 1;
    //     }
    //     int[] dp = new int[n+1];
    //     dp[1] = 1;
    //     dp[0] = 1;
    //     for(int i = 2; i < n+1; i++){
    //         dp[i] = dp[i-1] + dp[i-2];
    //     }
    //     return dp[n];
    // }
    
    /*
    使用完全背包方法：背包容量为n，有两件商品，分别占1和2，
    这两件商品数量不限定，问有多少种方法把背包装满
    注意这是一个排列问题，所以背包应该在外循环，商品在内循环
    动态规划：
    1、dp[i]:容量为i时的组合方法
    2、转移方程：if(i >= j) dp[i] += dp[i-j];
    3、初值：dp[0] = 1;

    45/45 cases passed (0 ms)
    Your runtime beats 100 % of java submissions
    Your memory usage beats 72.54 % of java submissions (35.1 MB)
    */
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i = 0; i <= n; i++){
            for(int j = 1; j <= 2; j++){
                if(i >= j){
                    dp[i] += dp[i-j];
                }   
            }
        }
        return dp[n];
    }
}
// @lc code=end

