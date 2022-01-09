package y2021.mediumtasks;

//https://leetcode.com/problems/zigzag-conversion/
public class ZizZagConversion {
    public static void main(String... args) {
        ZizZagConversion app = new ZizZagConversion();
        System.out.println(
                "PAHNAPLSIIGYIR " +
                app.convert("PAYPALISHIRING", 3));
    }
    public String convert(String s, int numRows) {
        if (s == null || s.length()<2)  return s;
        if (s.length()<numRows) return s;
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i<numRows; i++) {
            sb[i] = new StringBuilder();
        }
        int count = 0;
        int n = s.length();
        while(count<n) {
            for (int i = 0; i<numRows && (count<n); i++) {
                sb[i].append(s.charAt(count++));
            }

            for (int i = numRows-2; i>0 && (count<n); i--) {
                sb[i].append(s.charAt(count++));
            }
        }
        for (int i = 1; i<numRows; i++) {
            sb[0].append(sb[i].toString());
        }
        return sb[0].toString();
    }
}
