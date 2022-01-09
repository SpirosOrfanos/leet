package y2021.kickstart;

public class Playground {

    public static void main(String... args) {
        Playground app = new Playground();

        System.out.println( app.reverse("1234"));
        System.out.println( app.reverse("12345"));

        System.out.println( app.reverse("12345678", 2));
        System.out.println( app.reverse("123456789", 2));
        System.out.println(app.idPowerOf2(8));
        System.out.println(app.idPowerOf2(6));

        System.out.println(366%7);
    }

    boolean idPowerOf2(int x) {
        while (x>0) {
            if(x==1) return true;
            if (x%2!=0) return false;
            x/=2;
        }
        return true;
    }
    public String reverse(String s) {
        char[] c = s.toCharArray();
        for (int i = 0; i< s.length()/2; i++) {
            char temp = c[i];
            c[i] = c[s.length()-1-i];
            c[s.length()-1-i] = temp;
        }
        return new String(c);
    }
    public String reverse(String s, int shift) {
        System.out.println();
        System.out.println(s);
        char[] c = s.toCharArray();
        for (int i = 0; i< shift/2; i++) {
            char temp = c[i];
            c[i] = c[shift-1-i];
            c[shift-1-i] = temp;
        }
        int count = 0;
        for (int i = shift; i< (s.length()/2)+shift-1; i++) {
            char temp = c[i];
            c[i] = c[s.length()-1-count];
            c[s.length()-1-count] = temp;
            count++;
        }
        return reverse(new String(c));
    }
}
