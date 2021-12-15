/*
 * @lc app=leetcode.cn id=263 lang=java
 *
 * [263] 丑数
 */

// @lc code=start
class Solution {
    /*
    1013/1013 cases passed (0 ms)
    Your runtime beats 100 % of java submissions
    Your memory usage beats 32.58 % of java submissions (35.5 MB)
     */
    public boolean isUgly(int n) {
        if(n <= 0){
            return false;
        }
        if(n == 1){
            return true;
        }
        while(n!= 1){
            if(n % 2 == 0){
                n = n / 2;
                continue;
            }
            if(n % 3 == 0){
                n = n/3;
                continue;
            }
            if (n % 5 == 0) {
                n = n/5;
                continue;
            }
            break;
        }
        return n==1;
    }
}
// @lc code=end

