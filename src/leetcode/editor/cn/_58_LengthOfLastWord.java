//给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。 
//
// 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "Hello World"
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：s = " "
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅有英文字母和空格 ' ' 组成 
// 
// Related Topics 字符串 
// 👍 306 👎 0

package leetcode.editor.cn;

public class _58_LengthOfLastWord {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLastWord("a "));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public int lengthOfLastWord(String s) {
            int length = 0;
            boolean numStart = false;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) != ' ') {
                    //遇到不是空格的了，启动计数
                    numStart = true;
                    length++;
                } else if (numStart) {
                    //计数的时候遇到空格了，停止扫描
                    break;
                }
                //末尾几个都是空格，还没启动计数，进来不算
            }
            return length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}