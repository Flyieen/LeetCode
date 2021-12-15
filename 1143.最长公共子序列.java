/*
 * @lc app=leetcode.cn id=1143 lang=java
 *
 * [1143] 最长公共子序列
 */

// @lc code=start
class Solution {
    /*
    只要涉及到两个字符串求最长，就是二维数组存储暴力枚举（动态规划）
    二维可以转换成一维
    44/44 cases passed (12 ms)
    Your runtime beats 26.29 % of java submissions
    Your memory usage beats 60.57 % of java submissions (42 MB)
    */
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for (int i = 1; i <= text1.length(); i++){
            for (int j = 1; j <= text2.length(); j++){
                //注意这里的转移方程
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }    
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
// @lc code=end

