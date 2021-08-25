//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2344 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;

public class _20_ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("()[]{}"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public boolean isValid(String s) {
            if(s.length()%2 !=0){
                return false;
            }
            final LinkedList<Character> linkedList = new LinkedList<>();
            for (int i=0;i<s.length();i++){
                final char c = s.charAt(i);
                if(c == '(' || c == '[' || c == '{'){
                    linkedList.offerLast(c);
                }else if(linkedList.isEmpty() || !match(linkedList.pollLast(),c)){
                    return false;
                }
            }
            return linkedList.isEmpty();
        }

        private boolean match(char left,char right){
            switch (left){
                case '(': return right == ')';
                case '[': return right == ']';
                case '{': return right == '}';
                default:return false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}