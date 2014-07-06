Strategy
======

the definition from [wiki](http://en.wikipedia.org/wiki/Strategy_pattern)

the strategy pattern enables an algorithm's behavior to be selected at runtime. The strategy pattern

- defines a **family of algorithms**,
- encapsulates each algorithm
- makes the algorithms interchangeable within that family

sounds like some OO brogrammer who hasn't discovered high order function yet.

this is called strategy

```java
 public static <T> void sort(List<T> list, Comparator<? super T> c) {...}
```

in that:
- you can define a family of sort algorithms
- encapsulates each into a comparator
- and you can pass whatever sorting comparator you wrote to this method


I think the interviewer who ask you this kind of question would be really happy if you said  **a family of algorithms**.