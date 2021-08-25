//给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。 
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: rowIndex = 3
//输出: [1,3,3,1]
// 
//
// 示例 2: 
//
// 
//输入: rowIndex = 0
//输出: [1]
// 
//
// 示例 3: 
//
// 
//输入: rowIndex = 1
//输出: [1,1]
// 
//
// 
//
// 提示: 
//
// 
// 0 <= rowIndex <= 33 
// 
//
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？ 
// Related Topics 数组 动态规划 
// 👍 314 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class _119_PascalsTriangleIi {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(Collections.singletonList(1));
            for (int i = 1; i <= rowIndex; i++) {
                final List<Integer> lastRowResult = result.get(i - 1);
                LinkedList<Integer> rowResult = new LinkedList<>();
                rowResult.add(1);
                for (int j = 1; j <= lastRowResult.size() - 1; j++) {
                    int val = lastRowResult.get(j - 1) + lastRowResult.get(j);
                    rowResult.add(val);
                }
                rowResult.add(1);
                result.add(rowResult);
            }
            return result.get(rowIndex);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}