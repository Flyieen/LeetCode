/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */

// @lc code=start
class Solution {
    /*动态规划五部曲：
    1、dp[i][j]：网格[i][j]的路径总数
    2、状态转移方程：dp[i][j] = dp[i-1][j] + dp[i][j-1];
    如果有阻碍：则阻碍的dp[i][j] = 0;
    3、base case：(dp[0][j] = 1 dp[i][0] = 1)这个是错的，因为
    如果有阻碍堵死了所有的路不能到终点，这些值就会导致算出的值能
    到终点
    dp[0][0] = 1
    dp[i][0] = nums[i][0] == 1 ? 0 : dp[i-1][0]
    4、遍历顺序：从左上到右下，逐行遍历
    时间复杂度：O(m*n) //用了双重循环
    空间复杂度：O(m*n) //用了二维数组
    41/41 cases passed (0 ms)
    Your runtime beats 100 % of java submissions
    Your memory usage beats 56.99 % of java submissions (37.7 MB)
    */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1){
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        //这里还可以优化，如果有障碍，则后面都是0，不用再循环
        for(int i = 1; i < m; i++){
            dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : dp[i-1][0];
        }
        for(int j = 1; j < n; j++){
            dp[0][j] = obstacleGrid[0][j] == 1 ? 0 : dp[0][j-1];
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j] == 1){
                    continue;
                }
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
// @lc code=end

