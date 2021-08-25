//给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层序遍历为： 
//
// 
//[
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 二叉树 
// 👍 465 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class _107_BinaryTreeLevelOrderTraversalIi {
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

        private LinkedList<List<Integer>> result;

        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            result = new LinkedList<>();
            orderTree(root, 0);
            return result;
        }

        public void orderTree(TreeNode parent, int level) {
            if (parent == null) {
                return;
            }
            if (level > result.size() - 1) {
                result.addFirst(new LinkedList<>());
            }
            final List<Integer> bucket = result.get(result.size() - 1 - level);
            bucket.add(parent.val);
            orderTree(parent.left, level + 1);
            orderTree(parent.right, level + 1);
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