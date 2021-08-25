//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 你可以假设数组中无重复元素。 
//
// 示例 1: 
//
// 输入: [1,3,5,6], 5
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [1,3,5,6], 2
//输出: 1
// 
//
// 示例 3: 
//
// 输入: [1,3,5,6], 7
//输出: 4
// 
//
// 示例 4: 
//
// 输入: [1,3,5,6], 0
//输出: 0
// 
// Related Topics 数组 二分查找 
// 👍 894 👎 0

package leetcode.editor.cn;

public class _35_SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public int searchInsert(int[] nums, int target) {
            if (nums == null || nums.length == 0 || target <= nums[0]) {
                return 0;
            }
            int start = 0;
            int end = nums.length - 1;
            while (start <= end) {
                int mid = start + ((end - start) >> 1);
                if (target > nums[mid]) {
                    //比中间值大，说明在后一半
                    start = mid + 1;
                } else if (target > nums[mid - 1]) {
                    //小于等于中间值，并且比前一个值大，说明就放这里
                    return mid;
                } else {
                    //比中间值小，说明在前一半
                    end = mid - 1;
                }
            }
            return nums.length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}