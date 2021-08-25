//给你一个非负整数数组 nums ，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 假设你总是可以到达数组的最后一个位置。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 示例 2: 
//
// 
//输入: nums = [2,3,0,1,4]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 104 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 贪心 数组 动态规划 
// 👍 1099 👎 0

package leetcode.editor.cn;

public class _45_JumpGameIi {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {

        int min = 0;

        int[] nums;

        public int jump(int[] nums) {
            this.nums = nums;
            backTrack(0, 0);
            return min;
        }

        public void backTrack(int jmpSum, int nextIndex) {
            if (nextIndex == nums.length - 1) {
                min = jmpSum;
                return;
            }
            final int jump = nums[nextIndex];
            if (nextIndex + jump >= nums.length - 1) {
                min = jmpSum + 1;
                return;
            }
            int maxJmp = jump;
            int jmp = 1;
            for (int i = 1; i <= jump; i++) {
                final int i1 = nums[nextIndex + i] + i;
                if (i1 > maxJmp) {
                    jmp = i;
                    maxJmp = i1;
                }
            }
            backTrack(jmpSum + 1, nextIndex + jmp);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}