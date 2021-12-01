package kickstart;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class RoundA {
    public static void main(String... args)  throws IOException {
        RoundA app = new RoundA();
        String alp = "WXYZ";
        for (char c: alp.toCharArray()) {
      System.out.println(c + " "  + ((int) c));
        }
        app.increasingSubstring("REHKCELWPSXYYXRZGYJLFHOLDVZZMMYUPOLKYDWLISGYETBEEZNGAERNXVUZXTQUKKANMJYH", 1);
        //app.goodNess2("ABACDA", 2);
        /*BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        String cases = reader.readLine();
        int cs = Integer.parseInt(cases);
        for (int i = 0; i<cs; i++) {
            String size = reader.readLine();
            String str = reader.readLine();
            app.increasingSubstring(str, i+1);
        }*/

    }

    public void goodNess(String s, int k, int caseId) {
        int countUeq = 0;
        for (int i = 0; i< s.length()/2; i++) {
            if (s.charAt(i) !=s.charAt(s.length()-i-1))
                countUeq++;
        }

        System.out.println("Case #"+caseId+": "+(Math.abs(k-countUeq)));
    }

    public void increasingSubstring(String s, int caseId) {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        for (char c:s.toCharArray()) {
            q.add((int) c);
        }

        int max = Integer.MIN_VALUE;
        int count = 0;
        while (!q.isEmpty()) {


            int test = q.poll();
            if(test>max)  {
                count++;
                max = test;
            } else  {
                count = 1;
                max = test;
            }
      System.out.println((char) test  + " + " + count +  " " + test);
            sb.append(count + " ");
        }
        String res = sb.toString();
        if (sb.toString().length()>0) res = res.substring(0, res.length()-1);
        else res = sb.toString();
        System.out.println("Case #"+caseId+": "+res);
    }
}
