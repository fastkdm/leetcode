//给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// 
// 
// Related Topics 树 二叉搜索树 动态规划 回溯 二叉树 
// 👍 953 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class _95_UniqueBinarySearchTreesIi {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    static class Solution {
        public List<TreeNode> generateTrees(int n) {
            return generateChild(1, n);
        }

        public List<TreeNode> generateChild(int start, int end) {
            final LinkedList<TreeNode> childs = new LinkedList<>();
            if (start > end) {
                childs.add(null);
                return childs;
            }
            for (int i = start; i <= end; i++) {
                final List<TreeNode> leftNodes = generateChild(start, i - 1);
                final List<TreeNode> rightNodes = generateChild(i + 1, end);
                int finalI = i;
                leftNodes.forEach(leftNode -> rightNodes.forEach(rightNode -> childs.add(new TreeNode(finalI, leftNode, rightNode))));
            }
            return childs;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}