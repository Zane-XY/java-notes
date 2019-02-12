CyclicBarrier

A CyclicBarrier is a synchronizer that allows a set of threads to wait for each other to reach a common execution point, also called a barrier.

CyclicBarriers are used in programs in which we have a fixed number of threads that must wait for each other to reach a common point before continuing execution.

The barrier is called cyclic because it can be re-used after the waiting threads are released.

CyclicBarrier是java.util.concurrent包下面的一个工具类，字面意思是循环的（Cyclic）的屏障（Barrier），通过它可以实现让一组线程到达一个屏障（也可以叫同步点）时被阻塞，直到最后一个线程到达屏障时，所有被屏障拦截的线程才会继续执行。

[java - Real Life Examples For CountDownLatch and CyclicBarrier - Stack Overflow](https://stackoverflow.com/a/10156344)

The key difference is that CountDownLatch separates threads into waiters and arrivers while all threads using a CyclicBarrier perform both roles.

With a latch, the waiters wait for the last arriving thread to arrive, but those arriving threads don't do any waiting themselves.
With a barrier, all threads arrive and then wait for the last to arrive.


[CyclicBarrier (Java Platform SE 8 )](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CyclicBarrier.html)


```java
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 一个房间有4张桌子，最多容纳100人，最长不超过50 milliseconds有一个玩家进入房间
 * 每张桌子有4个位子，每张桌子从当前房间选择玩家，每个玩家准备时间不超过2000 milliseconds，当4个人都准备完成后， 游戏开始，游戏在1000 milliseconds内结束。
 *
 * @author xiaoye.wxy
 * @date 2019/02/11
 */
public class CyclicBarrierTest {
    /**
     * room hold 100 ppl at maximum
     */
    static BlockingQueue<Integer> room = new ArrayBlockingQueue<>(100);

    static class GameTask implements Runnable {
        String pplName;

        public GameTask(String pplName, CyclicBarrier cyclicBarrier) {
            this.pplName = pplName;
            this.cyclicBarrier = cyclicBarrier;
        }

        CyclicBarrier cyclicBarrier;

        @Override
        public void run() {
            //start game need a random preparation time
            try {
                System.out.println(pplName + " is preparing");
                Thread.sleep(ThreadLocalRandom.current().nextInt(2000));
                //done preparation, waiting for other ppl at the same table
                System.out.println(pplName + " is waiting");
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    static class TableTask implements Runnable {
        final Integer MAX_PLAYERS_PER_TABLE = 4;
        BlockingQueue<Integer> players = new ArrayBlockingQueue<>(MAX_PLAYERS_PER_TABLE);
        int round = 1;
        String tableName;

        public TableTask(String tableName) {
            this.tableName = tableName;
        }

        CyclicBarrier cyclicBarrier = new CyclicBarrier(MAX_PLAYERS_PER_TABLE, () -> {
            try {
                int gamingTime = ThreadLocalRandom.current().nextInt(1000);
                Thread.sleep(gamingTime);
                System.out.println("round " + round + ":  " + players.toString() + " at " + tableName + " has done the game in " + gamingTime + " milliseconds");
                players.clear();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            round++;
        });

        @Override
        public void run() {
            // take ppls from room
            while (true) {
                try {
                    if (players.size() < 4) {
                        Integer ppl = room.take();
                        System.out.println(ppl + " goes to " + tableName);
                        players.put(ppl);
                        new Thread(new GameTask(ppl.toString(), cyclicBarrier)).start();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        // ppl entering
        Thread pplEntering = new Thread(() -> {
            while (true) {
                int pplEnterInterval = ThreadLocalRandom.current().nextInt(50);
                try {
                    Thread.sleep(pplEnterInterval);
                    System.out.println(pplEnterInterval + " is entering the room, " + room.size() + " ppl are waiting ");
                    //block put if queue is full
                    room.put(pplEnterInterval);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        pplEntering.start();

        //4 tables
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(new TableTask("Table A"));
        executorService.submit(new TableTask("Table B"));
        executorService.submit(new TableTask("Table C"));
        executorService.submit(new TableTask("Table D"));
    }

}


```



