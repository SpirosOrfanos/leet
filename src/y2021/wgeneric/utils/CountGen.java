package y2021.wgeneric.utils;

public class CountGen {


    public static void main(String... args) {
        int p = 0;
        for (int i = 0;i<2000000; i++) {
            p^=(int)(Math.random()*10);
            if(p>15)System.out.println(p);
        }

        /*for (int i = 0;i<9; i++) {
            p^=(int)Math.random()*10;
            System.out.println(p);
        }
        for (int i = 0;i<9; i++) {
            p^=(int)(Math.random()*10);
            System.out.println(p);
        }*/
        //p^='A';
        //System.out.println(p);
        int x = 10;
        CountGen app = new CountGen();
    System.out.println(x);
    app.cha(x);
    System.out.println(x);
    }

    public void cha(int x) {
        x= 5;
    }

}
