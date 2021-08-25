//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics 数学 
// 👍 2709 👎 0

package leetcode.editor.cn;

public class _7_ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(12345));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public int reverse(int x) {
            int y;
            int z = x;
            int sum = 0;
            while ((y = z / 10) != 0) {
                sum = sum * 10 + z % 10;
                z = y;
                if (sum > Integer.MAX_VALUE / 10 || (sum == Integer.MAX_VALUE / 10 && z % 10 > 7)) {
                    return 0;
                }
                if (sum < Integer.MIN_VALUE / 10 || (sum == Integer.MIN_VALUE / 10 && z % 10 < -8)) {
                    return 0;
                }
            }
            sum = sum * 10 + z % 10;
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
