/*
 * @lc app=leetcode.cn id=935 lang=java
 *
 * [935] 骑士拨号器
 */

// @lc code=start
class Solution {
    //https://leetcode-cn.com/problems/knight-dialer/solution/dong-tai-gui-hua-4xing-ji-jian-100935-qi-xu27/
    /*
    分别把0、1379、28、46分组为a、b、c、d，初始值分别为1,4,2,2
    a, b, c, d, MOD = 1, 4, 2, 2, 1000000007
        for i in range(n-1): a, b, c, d = d, (2*c + 2*d) % MOD, b, (2*a + b) % MOD
    */

    /*
    下一轮，例如第N步要跳到1，则N-1步可能在6或8，所以a(N)=b(N-1)+c(N-1)
    121/121 cases passed (4 ms)
    Your runtime beats 100 % of java submissions
    Your memory usage beats 93.65 % o   f java submissions (35.1 MB)
    */
    public int knightDialer(int N) {
        if(N == 1) return 10;
        int mod = 1000000007;
        //a{1，3，7，9}，b{2，8}，c{4，6}，d{0}
        int a=2,b=2,c=3,d=2;
        for (int z = 0; z < N-2; ++z) {
            int e = (c+b)%mod;
            int f = (a*2)%mod;
            int g = (f+d)%mod;
            int h = (c*2)%mod;
            a=e;b=f;c=g;d=h;
        }
        return ((((a*2)%mod+(b+c)%mod)%mod*2)%mod+d)%mod;
    }
}
// @lc code=end

