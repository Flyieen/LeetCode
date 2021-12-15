/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 */

// @lc code=start
class Solution {
    /*
    完全背包问题：字符串s就是背包，字符串列表为商品，返回背包是否
    能够被商品装满
    动态规划五步：
    1、dp[i]:字符串长度为i的话，dp[i]为true，表示可以拆分为一个或
    多个在字典中出现的单词
    2、转移方程：如果确定dp[j] 是true，且 [j, i] 这个区间的子串出
    现在字典里，那么dp[i]一定是true。（j < i ）。
    所以递推公式是 if([j, i] 这个区间的子串出现在字典里 && dp[j]是
    true) 那么 dp[i] = true。
    3、初始值：dp[0] = true
    4、遍历方向：从前向后
    5、举例：leetcode “leet”，“code”


    45/45 cases passed (13 ms)
    Your runtime beats 5.54 % of java submissions
    Your memory usage beats 21.28 % of java submissions (38.8 MB)
     */
    // public boolean wordBreak(String s, List<String> wordDict) {
    //     boolean[] valid = new boolean[s.length() + 1];
    //     valid[0] = true;
    //     for (int i = 1; i <= s.length(); i++) {
    //         //背包放外层更方便，否则就需要将子串预选存在一个容器中
    //         for (int j = 0; j < i; j++) {
    //             /*
    //             1、wordDict.contains(s.substring(j,i))表示j之后到
    //             i的那个字符串片段可以匹配
    //             2、valid[j]表示[0...j]这一段字符串可以和字符串匹配
    //             */
    //             if (wordDict.contains(s.substring(j,i)) && valid[j]) {
    //                 valid[i] = true;
    //             }
    //         }
    //     }

    //     return valid[s.length()];
    // }

    /*
    45/45 cases passed (1 ms)
    Your runtime beats 99.59 % of java submissions
    Your memory usage beats 90.08 % of java submissions (36.8 MB)
    */
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length(), maxw = 0;
        boolean[] dp = new boolean[len + 1]; 
        dp[0] = true;
        Set<String> set = new HashSet();
        for(String str : wordDict){
            set.add(str);
            maxw = Math.max(maxw, str.length());
        }
        for(int i = 1; i < len + 1; i++){
            for(int j = i; j >= 0 && j >= i - maxw; j--){
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    //如果这里的j到i可以被匹配，就没必要让j再加的去了
                    //因为比如0-5已经匹配了，就没必要看1-5了
                    break;
                }
            }
        }
        return dp[len];
    }
}
// @lc code=end

