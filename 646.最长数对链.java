/*
 * @lc app=leetcode.cn id=646 lang=java
 *
 * [646] 最长数对链
 */

// @lc code=start
class Solution {
    /*最值问题采用动态规划来解、
    根据数对的第一个数排序数对，不然没有规律
    排完序后，pairs[i][0]<pairs[j][0](i<j)
    1、dp：dp[i]表示以pairs[i]结尾的数对链的长度
    2、转移方程：dp[j] = Math.max(dp[j],dp[i]+1)
    这个状态转移方程太巧妙了
    3、base case：dp数组的初值为1 (dp[0]=1会报错)
    如：[[-6,9],[1,6],[8,10],[-1,4],[-6,-2],[-9,8],[-5,3],[0,3]]
    expected：3  answer：2

    205/205 cases passed (41 ms)
    Your runtime beats 16.9 % of java submissions
    Your memory usage beats 97.11 % of java submissions (38.2 MB)
    时间复杂度：O(n^2) 因为有双重循环
    空间复杂度：O(n) dp占用的额外空间
     */
    // public int findLongestChain(int[][] pairs) {
    //     if (pairs == null || pairs.length == 0) {
    //         return 0;
    //     }
    //     Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
    //     int N = pairs.length;
    //     int[] dp = new int[N];
    //     Arrays.fill(dp, 1);
        
    //     for (int j = 1; j < N; ++j) {
    //         for (int i = 0; i < j; ++i) {
    //             if (pairs[i][1] < pairs[j][0])
    //                 dp[j] = Math.max(dp[j], dp[i] + 1);
    //         }
    //     }

    //     int ans = 0;
    //     for (int x: dp) if (x > ans) ans = x;
    //     return ans;
    // }

    /*
    贪心解法：在所有可作为下一个数对的集合中选择第二个数最小
    的数对添加到数对链。
    */
    public int findLongestChain(int[][] pairs) {
        //按照第二个数进行排序
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int cur = Integer.MIN_VALUE, ans = 0;
        for (int[] pair: pairs) {
            if (cur < pair[0]) {
                cur = pair[1];
                ans++;
            }
        }
        return ans;
    }
}
// @lc code=end

