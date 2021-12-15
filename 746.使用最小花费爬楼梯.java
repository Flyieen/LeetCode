/*
 * @lc app=leetcode.cn id=746 lang=java
 *
 * [746] 使用最小花费爬楼梯
 */

// @lc code=start
class Solution {
    /*动态规划五部曲：
    1、dp[i]:表示以cost[i]结尾的所花费的最小体力值
    2、转移方程：
    if(i + 2 < cost.length-1):
    dp[i] = Math.min(dp[i-1],dp[i-2])+cost[i]
    if(i + 2 < cost.length-1):
    dp[i] = Maht.min(dp[i-1],dp[i-2]+cost[i])
    因为i为最后一位时，i-1可以直接跳过它，不加是最好决策
    3、base case:dp[0] = cost[0] dp[1] = cost[1]
    4、遍历顺序：从前往后遍历
    5、举例：dp[0] = 10 dp[1]=15 dp[2]=15
    dp[0] = 1 dp[1]=100 dp[2]=2 dp[3]=3 dp[4]=3
    dp[5]=103 dp[6]=4 dp[7]=5 dp[8]=104 dp[9]=6
    空间优化：可以在原数组上修改
    时间复杂度：O(n)
    空间复杂度：O(1)

    283/283 cases passed (1 ms)
    Your runtime beats 89.61 % of java submissions
    Your memory usage beats 18.45 % of java submissions (38.2 MB)
    */
    // public int minCostClimbingStairs(int[] cost) {
    //     if(cost.length == 2){
    //         return Math.min(cost[0],cost[1]);
    //     }
    //     for(int i = 2; i < cost.length; i++){
    //         if(i < cost.length-1){
    //             cost[i] = Math.min(cost[i-2], cost[i-1]) + cost[i];
    //         }
    //         if(i == cost.length - 1){
    //             cost[i] = Math.min(cost[i-2]+cost[i], cost[i-1]);
    //         }
    //     }
    //     return cost[cost.length-1];
    // }
    

    /*
    为什么用了额外的dp0和dp1 还会更省空间呀
    283/283 cases passed (0 ms)
    Your runtime beats 100 % of java submissions
    Your memory usage beats 54.4 % of java submissions (38.1 MB)
    */
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length == 2){
            return Math.min(cost[0],cost[1]);
        }
        int dp1 = cost[1], dp0 = cost[0];
        for(int i = 2; i < cost.length; i++){
            cost[i] = Math.min(dp0, dp1) + cost[i];
            dp0 = dp1;
            dp1 = cost[i];
        }
        return Math.min(cost[cost.length-1],cost[cost.length - 2]);
    }
}
// @lc code=end

