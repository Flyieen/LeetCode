/*
 * @lc app=leetcode.cn id=509 lang=java
 *
 * [509] 斐波那契数
 */

// @lc code=start
class Solution {
    /*
    Your runtime beats 21.41 % of java submissions
    Your memory usage beats 87.14 % of java submissions (35 MB)
    */
    // public int fib(int n) {
    //     if(n == 0){
    //         return 0;
    //     }
    //     if(n == 1){
    //         return 1;
    //     }
    //     return fib(n-1) + fib(n - 2);
    // }
    public int fib(int n) {
        if(n == 0 || n == 1){
            return n;
        }
        int sum = 0;
        int [] f = new int [2];
        f[0] = 0;
        f[1] = 1;
        int i = 1;
        while(i < n){
            sum = f[0] + f[1];
            f[0] = f[1];
            f[1] = sum;
            i++;
        }
        return sum;
    }
}
// @lc code=end

