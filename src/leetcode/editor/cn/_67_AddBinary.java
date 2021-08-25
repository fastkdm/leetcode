//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 数学 字符串 
// 👍 600 👎 0

package leetcode.editor.cn;

public class _67_AddBinary {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("11","1"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public String addBinary(String a, String b) {
            int maxLength = Math.max(a.length(),b.length());
            boolean lowCarry = false;
            final char[] chars = new char[maxLength + 1];
            for (int i=maxLength-1;i>=0;i--){
                final int indexA = a.length() - (maxLength - i);
                final int indexB = b.length() - (maxLength - i);
                char charA = indexA < 0 ? '0': a.charAt(indexA);
                char charB = indexB < 0 ? '0': b.charAt(indexB);
                //a、b相同低位有进位，a、b不同低位无进位，那当前位结果为1
                chars[i+1] = charA == charB && lowCarry || ( charA != charB && !lowCarry) ? '1' : '0';
                //a、b都是1肯定向高位进位，低位进位且只要a、b有一个是1就向高位进位
                lowCarry = charA == '1' && charB == '1' || (lowCarry && (charA == '1' || charB == '1'));
            }
            if(lowCarry){
                chars[0] = '1';
                return String.valueOf(chars,0,chars.length);
            }else{
                return String.valueOf(chars,1,chars.length-1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}