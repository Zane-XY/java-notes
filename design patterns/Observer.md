Observer
======

The Observer Pattern defines a one-to-many dependency between objects so that when one object changes state, all of its dependents are notified and updated automatically.

Example: the publish - subscribe model.
Analogy: Just like how newspaper subscription works

#### read wiki [Observer Pattern](http://en.wikipedia.org/wiki/Observer_pattern)

####Java’s built-in Observer Pattern  

The java.util implementation of Observer/Observable is not the only place you’ll find the Observer Pattern in the JDK; both JavaBeans and Swing also provide their own implementations of the pattern.

```java
import java.util.Observable;
import java.util.Observer;

Class Observable //(it's a mistake ref)

Interface Observer

//register observers by using addObserver(Obeserver o)

/**
Adds an observer to the set of observers for this object, provided that it is not the same as some observer already in the set.

when data in Observable changed, you should call the setChanged() method.
*/
addObserver(Observer o)

/**
Marks this Observable object as having been changed; the hasChanged method will now return true.
*/
setChanged()

```
