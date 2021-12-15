import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution {
    /*
    基本思路：
    1.定义四个边界
    2.根据四个边界循环打印
    从左到右、从上到下、从右到左、从下到上
    3.然后重复

    23/23 cases passed (0 ms)
    Your runtime beats 100 % of java submissions
    Your memory usage beats 23.37 % of java submissions (36.6 MB)
    */
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        //处理空值
        if(matrix == null){
            return list;
        }
        int t = 0, l = 0, r = matrix[0].length-1, b = matrix.length-1;
        while(true){
            //从左往右
            for(int i = l; i <= r; i++){
                list.add(matrix[t][i]);
            }
            if(++t > b){
                break;
            }
            //从上到下
            for(int i = t; i <= b; i++){
                list.add(matrix[i][r]);
            }
            if(--r <l){
                break;
            }
            //从右到左
            for(int i = r; i >= l; i--){
                list.add(matrix[b][i]);
            }
            if(--b < t){
                break;
            }
            //从下到上
            for(int i = b; i >= t; i--){
                list.add(matrix[i][l]);
            }
            if(++l > r){
                break;
            }
        }
        return list;
    }
}
// @lc code=end

