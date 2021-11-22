package easytasks;

public class Fibonacci {
    public static void main(String... args) {
        Fibonacci app = new Fibonacci();
        System.out.println(app.fib(2));
    }

    public int fib(int n) {
        if (n<2) return 0;
        int[] arr = new int[n+1];
        arr[1] = 1;
        int count = 2;
        while (count<n+1) {
            arr[count] = arr[count-1] + arr[count-2];
            count++;
        }

        return arr[n];
    }
}
