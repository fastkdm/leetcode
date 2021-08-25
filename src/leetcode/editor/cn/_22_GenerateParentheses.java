//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 
// 👍 1949 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class _22_GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {

        private final LinkedList<String> result = new LinkedList<>();

        private int n;

        private final StringBuilder sb = new StringBuilder();

        public List<String> generateParenthesis(int n) {
            if (n == 0) {
                return new LinkedList<>();
            }
            this.n = n;
            generate('(', 1, 0);
            return result;
        }

        public void generate(char next, int left, int right) {
            sb.append(next);
            if (sb.length() == n * 2) {
                result.add(sb.toString());
                return;
            }
            if (left < n) {
                generate('(', left + 1, right);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (right < n && right < left) {
                generate(')', left, right + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}