Scheduling
======



#### differences between `scheduleAtFixedRate` and `scheduleWithFixedDelay`

#####summary
- both of them won't start the next scheduled task if the previous task is not finished.
- `scheduleAtFixedRate`  executes at every `n * period`
- `scheduleWithFixedDelay` means delay `n` after previous execution


- scheduleAtFixedRate
  - first after the given initial delay
  - subsequent tasks with the given period, If any execution of this task takes longer than its period, then subsequent executions  may start late, but will not concurrently execute.
  - time formula: `initialDelay`, `initialDelay + period`,  `initialDelay + 2 * period` ...

```java
scheduler.scheduleAtFixedRate(new Runnable() {
    @Override
    public void run() {
        System.out.println("scheduleAtFixedRate starts:    " + new Date());
        try {
            Thread.sleep(4000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("scheduleAtFixedRate    ends:    " + new Date());
    }
}, 1, 2L , SECONDS);
```

```
scheduleAtFixedRate starts:    Wed Jul 09 20:23:14 CST 2014
scheduleAtFixedRate   ends:    Wed Jul 09 20:23:18 CST 2014
scheduleAtFixedRate starts:    Wed Jul 09 20:23:18 CST 2014
scheduleAtFixedRate   ends:    Wed Jul 09 20:23:22 CST 2014
scheduleAtFixedRate starts:    Wed Jul 09 20:23:22 CST 2014
scheduleAtFixedRate   ends:    Wed Jul 09 20:23:26 CST 2014
scheduleAtFixedRate starts:    Wed Jul 09 20:23:26 CST 2014
```

- scheduleWithFixedDelay
  - first after the given initial delay
  - subsequent tasks with the given delay after the ternination of the last execution
  - time formula: `initialDelay`, `initialDelay + (executionTime + delay)`,  `initialDelay + 2 * (executionTime + delay)` ...

```java
scheduler.scheduleWithFixedDelay(new Runnable() {
    @Override
    public void run() {
        System.out.println("scheduleWithFixedDelay starts: " + new Date());
        try {
            Thread.sleep(4000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("scheduleWithFixedDelay   ends: " + new Date());
    }
}, 1, 3L, SECONDS);

```
```
scheduleWithFixedDelay starts: Wed Jul 09 20:01:04 CST 2014
scheduleWithFixedDelay   ends: Wed Jul 09 20:01:08 CST 2014
scheduleWithFixedDelay starts: Wed Jul 09 20:01:11 CST 2014
scheduleWithFixedDelay   ends: Wed Jul 09 20:01:15 CST 2014
scheduleWithFixedDelay starts: Wed Jul 09 20:01:18 CST 2014
scheduleWithFixedDelay   ends: Wed Jul 09 20:01:22 CST 2014
scheduleWithFixedDelay starts: Wed Jul 09 20:01:25 CST 2014
scheduleWithFixedDelay   ends: Wed Jul 09 20:01:29 CST 2014
```
