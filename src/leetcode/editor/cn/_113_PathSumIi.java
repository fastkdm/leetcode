//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,3], targetSum = 5
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], targetSum = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点总数在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
// 
// 
// Related Topics 树 深度优先搜索 回溯 二叉树 
// 👍 546 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class _113_PathSumIi {
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

        private int targetSum;

        private List<List<Integer>> results = new LinkedList<>();

        private HashMap<TreeNode, TreeNode> treeNodeHashMap = new HashMap<>();

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            this.targetSum = targetSum;
            findChild(root,0, null);
            return results;
        }

        public void findChild(TreeNode root, int sum, TreeNode parent) {
            if (root == null) {
                return;
            }
            treeNodeHashMap.put(root, parent);
            sum += root.val;
            if (sum == targetSum && root.left == null && root.right == null) {
                final LinkedList<Integer> result = new LinkedList<>();
                TreeNode par;
                while ((par = treeNodeHashMap.get(root)) != null) {
                    result.addFirst(root.val);
                    root = par;
                }
                result.addFirst(root.val);
                results.add(result);
                return;
            }
            findChild(root.left, sum, root);
            findChild(root.right, sum, root);
        }

    }

    public class TreeNode {
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