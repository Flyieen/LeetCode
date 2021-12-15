/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 */

// @lc code=start
class Solution {
    /*
    1.dp表示到该网格的路径和
    可以向下，也可以向右
    2.dp[m][n] = dp[m-1][n] + dp[m][n-1]
    3.初始状态：dp[0][j] = 1 dp[i][0] = 1;

    62/62 cases passed (0 ms)
    Your runtime beats 100 % of java submissions
    Your memory usage beats 5.23 % of java submissions (35.4 MB)

    应该可以进行状态压缩，减少空间复杂度，二维数组降低为一维
    */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 0;
        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
                if(i == 0 || j == 0){
                    dp[i][j] =  1;
                }else {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
// @lc code=end

