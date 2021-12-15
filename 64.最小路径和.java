/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
    /*解题思路：
    1.确定状态：最后一步只能从上到下，从左到右
    2.转移方程：dp[i][j] = Math.min(dp[i][j-1] + dp[i-1][j]) + grid[i][j]
    3.初始条件: dp[0][0] = grid[0][0]

    优化：可以直接利用原数组

    61/61 cases passed (3 ms)
    Your runtime beats 41.18 % of java submissions
    Your memory usage beats 26.48 % of java submissions (41.2 MB)
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0){
                    continue;
                }else if(i == 0 && j != 0){
                    grid[i][j] += grid[i][j-1];
                }else if(i != 0 && j == 0){
                    grid[i][j] += grid[i-1][j];
                }else{
                    grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
                }
            }
        }
        return grid[m-1][n-1];
    }
}
// @lc code=end

