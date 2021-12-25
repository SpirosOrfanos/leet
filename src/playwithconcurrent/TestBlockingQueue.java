package playwithconcurrent;


public class TestBlockingQueue {
    public static void main(String... args) {
        TestBlockingQueue app = new TestBlockingQueue();
        app.test();
    }

    void test() {
        MyBlickingQueue<CalculationFunction> q = new CalculationRunnableQueue();
        for (int i = 0; i< 20; i++) {
            q.enQueue(new CalculationFunction() {
                @Override
                public Integer apply(String s) {
                    Integer i;
                    try {
                        Thread.sleep(2000);
                        return Integer.parseInt(s);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return null;
                }
            });
        }

    }
}
