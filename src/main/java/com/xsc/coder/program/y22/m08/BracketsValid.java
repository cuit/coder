package com.xsc.coder.program.y22.m08;

import java.util.Stack;

/**
 * 描述
 * 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
 * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
 * <p>
 * 数据范围：字符串长度 0\le n \le 100000≤n≤10000
 * 要求：空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)
 * 示例1
 * 输入：
 * "()[]{}"
 * 复制
 * 返回值：
 * true
 * 复制
 * 示例2
 * 输入：
 * "[]"
 * 复制
 * 返回值：
 * true
 * 复制
 * 示例3
 * 输入：
 * "([)]"
 * 复制
 * 返回值：
 * false
 *
 * @author xia
 * @date 2022/8/30 23:14
 */
public class BracketsValid {

    /**
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isValid(String s) {
        // write code here
        if (s == null) {
            return false;
        }
        int length = s.length();
        if (length % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (i == 0) {
                    return false;
                }
                Character pop = stack.pop();
                if (pop != '(') {
                    return false;
                }
            } else if (c == ']') {
                if (i == 0) {
                    return false;
                }
                Character pop = stack.pop();
                if (pop != '[') {
                    return false;
                }
            } else if (c == '}') {
                if (i == 0) {
                    return false;
                }
                Character pop = stack.pop();
                if (pop != '{') {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        BracketsValid valid = new BracketsValid();
        System.out.println(valid.isValid("}(])[{(}([[}])}]))})]]({{(])"));
    }
}
