//假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。 
//
// 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x 3 的正整数矩阵 
//costs 来表示的。 
//
// 例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2] 表示第 1 号房子粉刷成绿色的花费，以此类推。 
//
// 请计算出粉刷完所有房子最少的花费成本。 
//
// 
//
// 示例 1： 
//
// 
//输入: costs = [[17,2,17],[16,16,5],[14,3,19]]
//输出: 10
//解释: 将 0 号房子粉刷成蓝色，1 号房子粉刷成绿色，2 号房子粉刷成蓝色。
//     最少花费: 2 + 5 + 3 = 10。
// 
//
// 示例 2： 
//
// 
//输入: costs = [[7,6,2]]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// costs.length == n 
// costs[i].length == 3 
// 1 <= n <= 100 
// 1 <= costs[i][j] <= 20 
// 
// 👍 128 👎 0

package leetcode.editor.cn;

public class _256_PaintHouse {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[][] costs;

        int lastSmallestIndex;

        int lastSecondSmallestIndex;

        public int minCost(int[][] costs) {
            this.costs = costs;
            initCache();
            for (int i = 1; i < costs.length; i++) {
                int smallestIndex = 0;
                int secondSmallestIndex = 0;
                for (int j = 0; j < costs[i].length; j++) {
                    if (j != lastSmallestIndex) {
                        costs[i][j] += costs[i - 1][lastSmallestIndex];
                    } else {
                        costs[i][j] += costs[i - 1][lastSecondSmallestIndex];
                    }
                    if (costs[i][j] <= costs[i][smallestIndex]) {
                        secondSmallestIndex = smallestIndex;
                        smallestIndex = j;
                    } else if (smallestIndex == secondSmallestIndex || costs[i][j] < costs[i][secondSmallestIndex]) {
                        secondSmallestIndex = j;
                    }
                }
                lastSmallestIndex = smallestIndex;
                lastSecondSmallestIndex = secondSmallestIndex;
            }
            return costs[costs.length - 1][lastSmallestIndex];
        }

        public void initCache() {
            lastSmallestIndex = 0;
            lastSecondSmallestIndex = 0;
            for (int j = 0; j < costs[0].length; j++) {
                if (costs[0][j] < costs[0][lastSmallestIndex]) {
                    lastSecondSmallestIndex = lastSmallestIndex;
                    lastSmallestIndex = j;
                } else if (lastSmallestIndex == lastSecondSmallestIndex || costs[0][j] <= costs[0][lastSecondSmallestIndex]) {
                    lastSecondSmallestIndex = j;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}