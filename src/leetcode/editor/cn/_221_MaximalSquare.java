//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：matrix = [["0","1"],["1","0"]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] 为 '0' 或 '1' 
// 
// 👍 843 👎 0

package leetcode.editor.cn;

public class _221_MaximalSquare {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalSquare(char[][] matrix) {
            final int[][] dp = new int[matrix.length][matrix[0].length];
            int max = 0;
            for (int y = 0; y < matrix.length; y++) {
                dp[y][0] = matrix[y][0] - '0';
                if (max == 0 && dp[y][0] == 1) {
                    max = 1;
                }
            }
            for (int x = 0; x < matrix[0].length; x++) {
                dp[0][x] = matrix[0][x] - '0';
                if (max == 0 && dp[0][x] == 1) {
                    max = 1;
                }
            }
            for (int y = 1; y < matrix.length; y++) {
                for (int x = 1; x < matrix[y].length; x++) {
                    if (matrix[y][x] == '0') {
                        dp[y][x] = 0;
                        continue;
                    }
                    int offset = Math.min(Math.min(dp[y][x - 1], dp[y - 1][x]), dp[y - 1][x - 1]) + 1;
                    max = Math.max(max, offset);
                    dp[y][x] = offset;
                }
            }
            return (int) Math.pow(max, 2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}