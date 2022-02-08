package y2022.asses;

public class FindTheDifference {
    public static void main(String[] args) {
        findTheDifference("", "");
    }

    public static char findTheDifference(String s, String t) {
        int[] data = new int[128];
        for (char c: s.toCharArray()) {
            data[(int) c]+=1;
        }

        for (char c: t.toCharArray()) {
            data[(int) c]+=1;
        }

        for (int i=0; i< data.length; i++) {
            if (data[i]!=0) {
                System.out.println(i);
                System.out.println(""+((char)(i)));
                return (char)(i) ;
            }
        }
        return '\u0000';
    }
}
