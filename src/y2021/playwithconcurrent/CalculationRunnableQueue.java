package y2021.playwithconcurrent;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CalculationRunnableQueue  extends MyBlickingQueue<CalculationFunction> {
    private ReentrantReadWriteLock rrl = new ReentrantReadWriteLock();
    private Queue<CalculationFunction> waitingQueue = new LinkedList<>();
    private ScheduledExecutorService executorService  = Executors.newScheduledThreadPool(1);
    private ScheduledExecutorService tick  = Executors.newScheduledThreadPool(1);;

    public CalculationRunnableQueue() {
        super(null);
        wq();
    }
    @Override
    public void enQueue(CalculationFunction calculationRunnable) {
        if (super.queue.remainingCapacity() > 0) {
            System.out.println("Add to queue");
            this.queue.add(calculationRunnable);
        } else  {
            System.out.println("Add to waitingQueue");
            waitingQueue.add(calculationRunnable);
        }
    }

    @Override
    public CalculationFunction get() {
        try {
            rrl.readLock().lock();
            System.out.println("Retrieve " + queue.remainingCapacity());
            return queue.take();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            rrl.readLock().unlock();
        }
        return null;
    }

    @Override
    public void wq() {
        executorService.scheduleAtFixedRate(() -> houseKeep(),  10, 5 , TimeUnit.SECONDS);
        tick.scheduleAtFixedRate(() -> offer(),  6, 2 , TimeUnit.SECONDS);
    }

    @Override
    protected void reset() {
        executorService.shutdown();
        queue.clear();
        waitingQueue.clear();
    }

    private void houseKeep() {
        System.out.println("houseKeep");
        if (!waitingQueue.isEmpty() && queue.remainingCapacity() >0) {
            System.out.println("houseKeep Add to Queue");
            enQueue(waitingQueue.poll());
        }
    }

    private void offer() {
        System.out.println(get().apply("1234"));
    }
}
