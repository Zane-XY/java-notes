parallell tasks
======

```java
List<Future<Integer>> futures = new ArrayList<Future<Integer>>();
ExecutorService ec = Executors.newFixedThreadPool( 2);
try {
    futures.add(ec.submit(new Callable<Integer>() {
        @Override
        public Integer call() throws Exception {
            return getMaleUserNum();
        }
    }));
    futures.add(ec.submit(new Callable<Integer>() {
        @Override
        public Integer call() {
            return getFemaleUserNum();
        }
    }));
    long result = 0;
    for (Future<Integer> future : futures) {
        result += future.get();
    }
} catch (Exception e) {
    e.printStackTrace();
} finally {
    ec.shutdown();
}
```
