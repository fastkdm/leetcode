//一条包含字母 A-Z 的消息通过以下映射进行了 编码 ： 
//
// 
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为： 
//
// 
// "AAJF" ，将消息分组为 (1 1 10 6) 
// "KJF" ，将消息分组为 (11 10 6) 
// 
//
// 注意，消息不能分组为 (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。 
//
// 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。 
//
// 题目数据保证答案肯定是一个 32 位 的整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "12"
//输出：2
//解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2： 
//
// 
//输入：s = "226"
//输出：3
//解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
//
// 示例 3： 
//
// 
//输入：s = "0"
//输出：0
//解释：没有字符映射到以 0 开头的数字。
//含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。
//由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
// 
//
// 示例 4： 
//
// 
//输入：s = "06"
//输出：0
//解释："06" 不能映射到 "F" ，因为字符串含有前导 0（"6" 和 "06" 在映射中并不等价）。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s 只包含数字，并且可能包含前导零。 
// 
// Related Topics 字符串 动态规划 
// 👍 905 👎 0

package leetcode.editor.cn;

public class _91_DecodeWays {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int numDecodings(String s) {
            if (s == null || s.length() == 0 || s.charAt(0) == '0') {
                return 0;
            }
            if (s.length() == 1) {
                return 1;
            }
            final int[] results = new int[s.length()];
            results[s.length() - 1] = 1;
            char last_1 = s.charAt(s.length() - 1);
            char last_2 = s.charAt(s.length() - 2);
            if(last_1 == '0' && last_2 != '1' && last_2 != '2'){
                return 0;
            }
            results[s.length() - 2] = last_1 != '0' && last_2 != '0' && Character.digit(last_2, 10) * 10 + Character.digit(last_1, 10) <= 26 ? 2 : 1;
            for (int i = s.length() - 3; i >= 0; i--) {
                final char afterChar_2 = s.charAt(i + 2);
                final char afterChar_1 = s.charAt(i + 1);
                final char thisChar = s.charAt(i);
                if (afterChar_1 == '0' && thisChar != '1' && thisChar != '2') {
                    return 0;
                } if (thisChar !='0' && afterChar_1 != '0' && afterChar_2 != '0' && Character.digit(thisChar, 10) * 10 + Character.digit(afterChar_1, 10) <= 26) {
                    results[i] = results[i + 1] + results[i + 2];
                } else {
                    results[i] = results[i + 1];
                }
            }
            return results[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}