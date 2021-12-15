import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    /*
    91/91 cases passed (2 ms)
    Your runtime beats 56.34 % of java submissions
    Your memory usage beats 93.24 % of java submissions (36.2 MB)
    */
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for(int i=0; i<s.length(); ++i){
            char c = s.charAt(i);
            if(!stack.isEmpty()){
                char t = stack.peekLast();
                if(t=='(' && c==')' 
                    || t=='[' && c==']'
                    || t=='{' && c=='}'){
                    stack.pollLast();
                    continue;
                }
            }
            stack.addLast(c);
        }
        return stack.isEmpty();
    }
}
// @lc code=end

