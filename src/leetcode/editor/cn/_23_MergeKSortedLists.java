//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// 👍 1520 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.List;

public class _23_MergeKSortedLists {
      
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        ListNode returnNode = head;
        while (true){
            int i = 0;
            int minIndex = Integer.MIN_VALUE;
            for (;i<lists.length;i++){
                if(lists[i] != null){
                    minIndex = i;
                    break;
                }
            }
            if(minIndex == Integer.MIN_VALUE){
                break;
            }
            for (;i<lists.length;i++){
                if(lists[i] == null){
                    continue;
                }
                if(lists[i].val < lists[minIndex].val){
                    minIndex = i;
                }
            }
            head.next = lists[minIndex];
            lists[minIndex] = lists[minIndex].next;
            head = head.next;
        }
        return returnNode.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}