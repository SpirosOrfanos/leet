package easytasks;

public class PalindromeNumber {
    public static void main(String... args) {
        PalindromeNumber app = new PalindromeNumber();
        app.isPalindrome(-121);
    }

    public boolean isPalindrome(int x) {
        if(x< 0) return false;
        if(x<10 ) return true;
        if(x%10 == 0) return false;
        int tmp = x;
        int res = 0;
        int rem;
        while(x>0) {
            rem = x%10;
            res = 10*res+rem;
            x/=10;
        }
    System.out.println(res);
        return res == tmp;
    }
}
