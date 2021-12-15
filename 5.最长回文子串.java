/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    /*
    1.dp数组的含义：dp[i][j]在子串s[i,...j]中，最长回文子序列的长度为
    dp[i][j]  m和n用来表示最大值的起始index和终止index
    2.转移方程：
    3.初始条件：if i ==j ,dp[i][j] = 1
    */
    public String longestPalindrome(String s) {
        int n = s.length();
		String res = "";
		boolean[] P = new boolean[n];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = n - 1; j >= i; j--) {
                //我们其实只需要i+1，j-1的数据，所以j-i<3
				P[j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || P[j - 1]);
				if (P[j] && j - i + 1 > res.length()) {
					res = s.substring(i, j + 1);
				}
			}
		}
		return res;
    }
}
// @lc code=end

