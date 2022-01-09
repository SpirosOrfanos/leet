package y2021.mediumtasks;

public class NumberOfBin {

    public static void main(String... args) {
        NumberOfBin app = new NumberOfBin();
    System.out.println(app.countBinarySubstrings("00110"));
    }
    public int countBinarySubstrings(String s) {

        int[] count = new int[2];
        char[] chars = s.toCharArray();
        int res = 0;
        count[Integer.parseInt(String.valueOf(chars[0]))]++;
        for (int i =1; i < chars.length; i++) {
            if (chars[i] != chars[i - 1]) {
                res += Math.min(count[0], count[1]);
                count[Integer.parseInt(String.valueOf(chars[i]))] = 1;
            }
            else
                count[Integer.parseInt(String.valueOf(chars[i]))]++;
        }
        res += Math.min(count[0], count[1]);
        return res;
    }
}
