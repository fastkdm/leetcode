//给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 *
// 。 
//
// 示例 1: 
//
// 输入: "2-1-1"
//输出: [0, 2]
//解释: 
//((2-1)-1) = 0 
//(2-(1-1)) = 2 
//
// 示例 2: 
//
// 输入: "2*3-4*5"
//输出: [-34, -14, -10, -10, 10]
//解释: 
//(2*(3-(4*5))) = -34 
//((2*3)-(4*5)) = -14 
//((2*(3-4))*5) = -10 
//(2*((3-4)*5)) = -10 
//(((2*3)-4)*5) = 10 
// 👍 411 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class _241_DifferentWaysToAddParentheses {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        String expression;

        public List<Integer> diffWaysToCompute(String expression) {
            this.expression = expression;
            return partition(0, expression.length() - 1);
        }

        public List<Integer> partition(int start, int end) {
            List<Integer> results = new LinkedList<>();
            boolean matchOpera = false;
            for (int i = start; i < end; i++) {
                final char c = expression.charAt(i);
                if (!Character.isDigit(c)) {
                    matchOpera = true;
                    List<Integer> left = partition(start, i - 1);
                    List<Integer> right = partition(i + 1, end);
                    List<Integer> result = merge(left, right, c);
                    results.addAll(result);
                }
            }
            if (!matchOpera) {
                results.add(Integer.parseInt(expression, start, end + 1, 10));
            }
            return results;
        }

        public List<Integer> merge(List<Integer> lefts, List<Integer> rights, char operator) {
            List<Integer> result = new LinkedList<>();
            switch (operator) {
                case '+':
                    lefts.forEach(left -> rights.forEach(right -> result.add(left + right)));
                    break;
                case '-':
                    lefts.forEach(left -> rights.forEach(right -> result.add(left - right)));
                    break;
                case '*':
                    lefts.forEach(left -> rights.forEach(right -> result.add(left * right)));
                    break;
                default:
                    break;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}