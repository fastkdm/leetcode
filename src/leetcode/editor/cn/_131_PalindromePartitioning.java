//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 回溯 
// 👍 804 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class _131_PalindromePartitioning {

    public static void main(String[] args) {
        new Solution().partition("aab");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {

        private List<List<String>> result = new LinkedList<>();
        private HashMap<Character, LinkedList<Integer>> cache = new HashMap<>();
        private HashMap<Integer, List<String>> part = new HashMap<>();
        private String s;

        public List<List<String>> partition(String s) {
            this.s = s;
            initCache();
            initPart();
            backTrack(0, new LinkedList<>());
            return result;
        }

        public void initCache() {
            for (int i = 0; i <= s.length() - 1; i++) {
                cache.putIfAbsent(s.charAt(i), new LinkedList<>());
                cache.get(s.charAt(i)).add(i);
            }
        }

        private void initPart() {
            for (int i = 0; i <= s.length() - 1; i++) {
                final LinkedList<Integer> charCache = cache.get(s.charAt(i));
                final Integer first = charCache.removeFirst();
                List<String> strings = new LinkedList<>();
                part.put(first, strings);
                strings.add(String.valueOf(s.charAt(first)));
                loop:
                for (int p = 0; p <= charCache.size() - 1; p++) {
                    int start = first;
                    int next = charCache.get(p);
                    int end = next;
                    while (start <= end) {
                        if (s.charAt(start) != s.charAt(end)) {
                            continue loop;
                        }
                        start++;
                        end--;
                    }
                    StringBuilder sb = new StringBuilder();
                    for (int k = first; k <= next; k++) {
                        sb.append(s.charAt(k));
                    }
                    strings.add(sb.toString());
                }
            }
        }

        private void backTrack(int start, LinkedList<String> before) {
            if (start > s.length() - 1) {
                result.add(new ArrayList<>(before));
                return;
            }
            for (String string : part.get(start)) {
                before.add(string);
                backTrack(start + string.length(), before);
                before.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}