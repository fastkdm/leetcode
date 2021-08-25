//给你一个整数 n ，请你找出并返回第 n 个 丑数 。 
//
// 丑数 就是只包含质因数 2、3 和/或 5 的正整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10
//输出：12
//解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
//解释：1 通常被视为丑数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1690 
// 
// 👍 725 👎 0

package leetcode.editor.cn;

public class _264_UglyNumberIi {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthUglyNumber(int n) {
            final int[] dp = new int[n];
            dp[0] = 1;
            int p2 = 0;
            int p3 = 0;
            int p5 = 0;
            for (int i = 1; i < n; i++) {
                int multi2 = dp[p2] * 2;
                int multi3 = dp[p3] * 3;
                int multi5 = dp[p5] * 5;
                if (multi2 <= multi3 && multi2 <= multi5) {
                    dp[i] = multi2;
                    p2++;
                } else if (multi3 < multi2 && multi3 <= multi5) {
                    dp[i] = multi3;
                    p3++;
                } else {
                    dp[i] = multi5;
                    p5++;
                }
                if (multi2 == multi3) {
                    p3++;
                }
                if (multi2 == multi5 || multi3 == multi5) {
                    p5++;
                }
            }
            return dp[n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}