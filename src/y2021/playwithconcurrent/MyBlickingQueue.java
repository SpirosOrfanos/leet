package y2021.playwithconcurrent;


import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.function.Function;

public abstract class MyBlickingQueue <T extends Function> {

    protected BlockingQueue<T> queue;
    public MyBlickingQueue(Integer capacity) {
        this.queue = new LinkedBlockingDeque<>(Objects.isNull(capacity) || capacity.intValue()<=0 ? Integer.parseInt(System.getenv("NUMBER_OF_PROCESSORS")) : capacity.intValue());
    }

    protected abstract void enQueue(T t);
    protected abstract T get();
    protected abstract void wq();
    protected abstract void reset();

}
