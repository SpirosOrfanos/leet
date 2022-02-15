package y2022.mid;

import java.util.*;
public class GenerateParantheses {
    public static void main(String[] args) {
        GenerateParantheses app = new GenerateParantheses();
        System.out.println(app.generateParenthesis(3));
    }
    public List<String> generateParenthesis(int n) {
        List<String> l = new ArrayList<>();
        generateParenthesis(n, "", 0, 0, l);
        return l;
    }

    public void generateParenthesis(int n, String sofar, int left, int right,  List<String> res) {
        if(sofar.length() == n*2) {
            res.add(sofar);
            return;
        }

        if(left<n)
            generateParenthesis(n, sofar+"(", left+1, right, res);
        if(right<left)
            generateParenthesis(n, sofar+")", left, right+1, res);
    }
}
