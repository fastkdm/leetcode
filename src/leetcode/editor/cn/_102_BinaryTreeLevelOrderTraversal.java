//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 二叉树 
// 👍 958 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class _102_BinaryTreeLevelOrderTraversal {
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

        public List<List<Integer>> levelOrder(TreeNode root) {
            final LinkedList<List<Integer>> lists = new LinkedList<>();
            nextLevel(root, lists, 0);
            return lists;
        }

        public void nextLevel(TreeNode root, List<List<Integer>> result, int index) {
            if (root == null) {
                return;
            }
            List<Integer> list;
            if (result.size() <= index) {
                list = new LinkedList<>();
                result.add(list);
            } else {
                list = result.get(index);
            }
            list.add(root.val);
            int nextLevel = index + 1;
            nextLevel(root.left, result, nextLevel);
            nextLevel(root.right, result, nextLevel);
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