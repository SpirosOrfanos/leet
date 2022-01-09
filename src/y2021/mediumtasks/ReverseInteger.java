package y2021.mediumtasks;

public class ReverseInteger {
    public static void main(String... args) {
        ReverseInteger app = new ReverseInteger();
        System.out.println(app.reverse(120));
        System.out.println(app.reverse(121));
        System.out.println(app.reverse(1221));
        System.out.println(app.reverse(0));
        System.out.println(app.reverse(3));
        System.out.println(app.reverse(1234));

    }

    public int reverse(int x) {

        if (x>Integer.MAX_VALUE) return 0;
        boolean isNegative = x<0;
        if(isNegative) x*=-1;
        if(x<10) return x;

        int res = 0;
        while (x>0) {
            res = res*10 + x%10;
            x/=10;
        }
        return isNegative?res*-1:res;
    }
}
