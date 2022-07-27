package y2022_3.hard;


import java.util.Stack;

//https://leetcode.com/problems/longest-valid-parentheses/
public class LongestValidParenthesis {
    public static void main(String... args) {
        LongestValidParenthesis app = new LongestValidParenthesis();
        app.longestValidParentheses("()");
    }

    public int longestValidParentheses(String s) {
        int res = 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(')st.push(i);
            else{
                st.pop();
                if(st.isEmpty()){
                    st.push(i);
                }else{
                    res = Math.max(res, i - st.peek());
                }
            }
        }

        return res;
    }
}
