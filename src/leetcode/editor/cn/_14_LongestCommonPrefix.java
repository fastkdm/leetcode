//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 0 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1569 👎 0

package leetcode.editor.cn;

public class _14_LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{"ab", "a"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }else if( strs.length == 1){
                return strs[0];
            }
            int minStringIndex = 0;
            for (int i = 1; i < strs.length; i++) {
                minStringIndex = strs[minStringIndex].length() < strs[i].length() ? minStringIndex : i;
            }
            final String minStr = strs[minStringIndex];
            for (int i = 0; i < minStr.length(); i++) {
                final char c = minStr.charAt(i);
                for (int j = 0; j < strs.length; j++) {
                    if(j == minStringIndex){
                        continue;
                    }
                    if (strs[j].charAt(i) != c) {
                        return minStr.substring(0,i);
                    }
                }
            }
            return minStr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}