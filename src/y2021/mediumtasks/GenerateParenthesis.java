package y2021.mediumtasks;

import java.util.*;
public class GenerateParenthesis {
    public static void main(String... args) {
        GenerateParenthesis app = new GenerateParenthesis();
        System.out.println(app.generateParenthesis(3));
    }
    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();

        if (n==0) return res;
        gen(n, res, 0, 0, "");
        return res;
    }

    public void gen(int n, List<String> res, int start, int end, String sf) {

        if (sf.length() == n*2) {
            res.add(sf);
              System.out.println(start + " : " + end);
            return;
        }
        if (start<n) {
            gen(n, res, start+1, end, sf+"(");
        }

        if(end<start) {
            gen(n, res, start, end+1, sf+")");
        }
    }
   /* public List<String> generateParenthesis(int n) {
        if(n<1) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        generateParenthesis(res, "", 0, 0, n);
        return res;
    }

    public void generateParenthesis(List<String> res, String curr, int left, int right, int n) {
        if (curr.length() == n*2) {
            res.add(curr);
            return;
        }
        if(left<n) {
            generateParenthesis(res, curr+"(", left+1, right, n);
        }
        if(right<left) {
            generateParenthesis(res, curr+")", left, right+1, n);
        }
    }*/
}
