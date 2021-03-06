//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 100 
// 
// Related Topics 数组 动态规划 矩阵 
// 👍 961 👎 0

package leetcode.editor.cn;

public class _64_MinimumPathSum {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPathSum(int[][] grid) {
            for (int y = 1; y <= grid[0].length - 1; y++) {
                grid[0][y] = grid[0][y - 1] + grid[0][y];
            }
            for (int x = 1; x <= grid.length - 1; x++) {
                grid[x][0] = grid[x - 1][0] + grid[x][0];
            }
            for (int y = 1; y <= grid[0].length - 1; y++) {
                for (int x = 1; x <= grid.length - 1; x++) {
                    grid[x][y] = Math.min(grid[x - 1][y], grid[x][y - 1]) + grid[x][y];
                }
            }
            return grid[grid.length - 1][grid[0].length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}