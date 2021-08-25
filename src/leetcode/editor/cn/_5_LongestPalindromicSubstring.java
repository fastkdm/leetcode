//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3568 👎 0

package leetcode.editor.cn;

public class _5_LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.longestPalindrome("babad");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public String longestPalindrome(String s) {
            if (s.length() < 2) {
                return String.valueOf(s.charAt(0));
            }
            var startIndex = 0;
            var endIndex = 0;
            for (var i = 1; i < s.length(); i++) {
                int left =  i - 1;
                int right = i;
                while (left >= 0){
                    if(s.charAt(left) == s.charAt(i)){
                        left--;
                    }else{
                        break;
                    }
                }
                while (right < s.length()){
                    if(s.charAt(right) == s.charAt(i)){
                        right++;
                    }else{
                        break;
                    }
                }
                while (left >= 0 && right < s.length()) {
                    if(s.charAt(left) != s.charAt(right)){
                        break;
                    }
                    left--;
                    right++;
                }
                if (right - left - 2 > endIndex - startIndex) {
                    startIndex = left+1;
                    endIndex = right-1;
                }
            }
            return s.substring(startIndex, endIndex+1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}