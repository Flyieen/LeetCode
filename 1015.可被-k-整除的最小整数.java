/*
 * @lc app=leetcode.cn id=1015 lang=java
 *
 * [1015] 可被 K 整除的最小整数
 */

// @lc code=start
class Solution {
    /*
    循环去找合适的x：
    x = 1
    cnt = 1;
    while (x % K != 0)
    {
        x = x * 10 + 1;
        ++cnt;
    }
    这里会溢出，所以改为 x %= k; x = x * 10 + 1;

    死循环的可能性
    其实就是2 和 5 的倍数, 此时10能被整除，需要排除

    代码

    70/70 cases passed (1 ms)
    Your runtime beats 100 % of java submissions
    Your memory usage beats 98.21 % of java submissions (34.7 MB)
    */
    public int smallestRepunitDivByK(int k) {
        if(k % 2 == 0 || k % 5 == 0){
            return -1;
        }
        int temp = 1;
        int cnt = 1;
        while (temp % k != 0)
        {
            temp %= k;
            temp = temp * 10 + 1;
            ++cnt;
        }

        return cnt;
    }
}
// @lc code=end

