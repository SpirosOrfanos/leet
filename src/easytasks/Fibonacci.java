package easytasks;

/*
https://leetcode.com/problems/fibonacci-number/
https://leetcode.com/problems/n-th-tribonacci-number/
 */
public class Fibonacci {
    public static void main(String... args) {
        Fibonacci app = new Fibonacci();
       // System.out.println(app.fib(2));
       // System.out.println(app.fib(3));
        System.out.println(app.fib(4));
        System.out.println(app.fibSeries(25));
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

         //   System.out.println(sum);
        return arr[n];
    }

    public int fibSeries(int n) {
        if (n<1) return 0;
        if (n<3) return 1;
        int[] arr = new int[n+1];
        arr[1] = 1;
        arr[2] = 1;
        int count = 3;
        while (count<n+1) {
            arr[count] = arr[count-1] + arr[count-2]+arr[count-3];
            count++;
        }

        //   System.out.println(sum);
        return arr[n];
    }
}
