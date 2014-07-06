Abstract Factory
======
this pattern is so simple that almost sounds ridiculous to call this as a design pattern.
If you know how Polymorphism works in OO languages, it's just means a method takes a polymorphic type.

I found [this explaination](http://java.dzone.com/articles/design-patterns-abstract-factory) is close to the original definition.

```java
public void buildWindow(AbstractWidgetFactory widgetFactory)
```

@[a not tested example](AbstractFactory.java)

##### .newInstance()
this mostly indicates it's a *static factory method* pattern instead of *abstract factory* or the *factory method*.
the *static factory method* pattern is seen in *Effective Java* and said to have the following features:
- hide initialisation process, if you use constructors you have to create objects every time, but this can hide the creation details, and let you decide if you need to create a new object on heap. <br> ```java Runtime.getRuntime() // singleton
Boolean.valueOf(true) // flyweight return cached value
```
- 