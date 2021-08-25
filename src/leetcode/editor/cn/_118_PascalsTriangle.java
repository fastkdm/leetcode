//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。 
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
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
//
// 示例 2: 
//
// 
//输入: numRows = 1
//输出: [[1]]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= numRows <= 30 
// 
// Related Topics 数组 动态规划 
// 👍 547 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class _118_PascalsTriangle {

    public static void main(String[] args) {
        new Solution().generate(5);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(Collections.singletonList(1));
            for (int i = 1; i < numRows; i++) {
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
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}