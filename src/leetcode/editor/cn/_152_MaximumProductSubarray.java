//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// 👍 1238 👎 0

package leetcode.editor.cn;

public class _152_MaximumProductSubarray {

    public static void main(String[] args) {
        new Solution().maxProduct(new int[]{2, -5, -2, -4, 3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public int maxProduct(int[] nums) {
            int lastMax = 0, lastMin = 0;
            if (nums[0] > 0) {
                lastMax = nums[0];
            } else if (nums[0] < 0) {
                lastMin = nums[0];
            }
            int result = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i - 1] == 0) {
                    if (nums[i] > 0) {
                        lastMax = Math.max(nums[i], lastMax);
                    } else if (nums[i] < 0) {
                        lastMin = Math.min(nums[i], lastMin);
                    }
                } else {
                    if (nums[i] > 0) {
                        lastMax = Math.max(lastMax * nums[i], nums[i]);
                        lastMin = lastMin * nums[i];
                    } else if (nums[i] < 0) {
                        int temp = lastMax;
                        lastMax = lastMin * nums[i];
                        lastMin = Math.min(temp * nums[i], nums[i]);
                    } else {
                        lastMax = 0;
                        lastMin = 0;
                    }
                }
                result = Math.max(result, lastMax);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}