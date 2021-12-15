import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=516 lang=java
 *
 * [516] 最长回文子序列
 */

// @lc code=start
class Solution {
    /*解决思路：
    1.dp数组：在子串s[i...j]中,最长回文子序列的长度为dp[i][j]
    2.状态转移方程：如果s[i] = s[j]，dp[i][j] = dp[i+1][j-1]+2
    如果s[i] != s[j]，则dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j-1])
    3.初始条件：dp[i][j] = 1(i与j相等的情况下)

    86/86 cases passed (37 ms)
    Your runtime beats 49.74 % of java submissions
    Your memory usage beats 85.28 % of java submissions (48 MB)
    */
//     public int longestPalindromeSubseq(String s) {
//         int[][] dp = new int[s.length()][s.length()];
//         for(int i = 0; i < s.length(); i++){
//             dp[i][i] = 1;
//         }
//         for (int i = s.length()-2; i >= 0; i--){
//             for(int j = i+1; j < s.length(); j++){
//                 if(s.charAt(i) == s.charAt(j)){
//                     dp[i][j] = dp[i+1][j-1] + 2;
//                 }else {
//                     dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
//                 }
//             }
//         }
//         return dp[0][s.length()-1];
//     }
// }

    /*
    因为dp[i][j]需要dp[i][j]相邻的状态，所以可以使用状态压缩技巧
    labuladong 141页，最终要的是144页的图
    此问题中最重要的就是处理dp[i+1][j-1]，因为它会被覆盖掉，需要
    用临时值保存，但是这个临时值如何保存就是最难的地方
    通过二维数组i,j的遍历过程，可以理解为什么要设置pre和temp，以及
    它们是如何保存dp[i+1][j-1]用于计算的

    86/86 cases passed (36 ms)
    Your runtime beats 52.93 % of java submissions
    Your memory usage beats 97.61 % of java submissions (36.5 MB)
    */
    public int longestPalindromeSubseq(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, 1);
        for(int i = s.length()-2; i >= 0; i--){
            int pre = 0;//用来保存内层for循环中上一次迭代的temp值
            for(int j = i+1; j < s.length(); j++){
                int temp = dp[j];//用来保存dp[i+1][j-1]，因为这个值会在循环中被dp[i][j-1]覆盖
                if(s.charAt(i) == s.charAt(j)){
                    //dp[i][j] = dp[i-1][j+1] + 2
                    dp[j] = pre + 2;
                }else {
                    //dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j])
                    dp[j] = Math.max(dp[j], dp[j-1]);
                }
                pre = temp;
            }
        }
        return dp[s.length()-1];
    }
}
// @lc code=end

