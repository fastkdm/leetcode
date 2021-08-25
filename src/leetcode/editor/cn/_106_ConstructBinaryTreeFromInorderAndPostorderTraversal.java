//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 数组 哈希表 分治 二叉树 
// 👍 544 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

public class _106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
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

        private int[] postorder;

        private HashMap<Integer, Integer> inorder;

        private int postorderIndex;

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            this.postorder = postorder;
            this.postorderIndex = postorder.length - 1;
            this.inorder = new HashMap<>(inorder.length);
            for (int i = 0; i < inorder.length; i++) {
                this.inorder.put(inorder[i], i);
            }
            return findChild(0, inorder.length - 1);
        }

        public TreeNode findChild(int start, int end) {
            if (postorderIndex < 0) {
                return null;
            }
            final int parVal = postorder[postorderIndex--];
            final Integer i = inorder.get(parVal);
            final TreeNode treeNode = new TreeNode(parVal);
            if (i < end) {
                treeNode.right = findChild(i + 1, end);
            }
            if (i > start) {
                treeNode.left = findChild(start, i - 1);
            }
            return treeNode;
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