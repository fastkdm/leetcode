//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 示例 1： 
//
// 
//输入：m = 3, n = 7
//输出：28 
//
// 示例 2： 
//
// 
//输入：m = 3, n = 2
//输出：3
//解释：
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向下
// 
//
// 示例 3： 
//
// 
//输入：m = 7, n = 3
//输出：28
// 
//
// 示例 4： 
//
// 
//输入：m = 3, n = 3
//输出：6 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 100 
// 题目数据保证答案小于等于 2 * 109 
// 
// Related Topics 数学 动态规划 组合数学 
// 👍 1076 👎 0

package leetcode.editor.cn;

public class _62_UniquePaths {

    public static void main(String[] args) {
        new Solution().uniquePaths(3,7);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {

        public int uniquePaths(int m, int n) {
            int[][] cache = new int[m + 1][n + 1];
            for (int i=1;i<=m;i++){
                cache[i][1] = 1;
            }
            for (int i=1;i<=n;i++){
                cache[1][i] = 1;
            }
            for (int y = 2; y <= n; y++) {
                for (int x = 2; x <= m; x++) {
                    cache[x][y] = cache[x - 1][y] + cache[x][y - 1];
                }
            }
            return cache[m][n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}