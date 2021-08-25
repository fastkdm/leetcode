//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = [1,2,3]
//输出：[1,2,4]
//解释：输入数组表示数字 123。
// 
//
// 示例 2： 
//
// 
//输入：digits = [4,3,2,1]
//输出：[4,3,2,2]
//解释：输入数组表示数字 4321。
// 
//
// 示例 3： 
//
// 
//输入：digits = [0]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= digits.length <= 100 
// 0 <= digits[i] <= 9 
// 
// Related Topics 数组 
// 👍 674 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class _66_PlusOne {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.plusOne(new int[]{9,9})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public int[] plusOne(int[] digits) {
            int plusIndex = digits.length - 1;
            return plusOne(plusIndex, digits);
        }

        private int[] plusOne(int plusIndex, int[] digits) {
            int value = digits[plusIndex];
            if (value == 9) {
                if(plusIndex == 0){
                    int[] dest = new int[digits.length + 1];
                    System.arraycopy(digits,0,dest,1,digits.length);
                    digits = dest;
                    plusIndex++;
                }
                digits[plusIndex] = 0;
                digits = plusOne(plusIndex - 1, digits);
            } else {
                digits[plusIndex]++;
            }
            return digits;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}