Static 
======
#####static variables can be used to save class state

keep-a-running-total-of-instances:

```java
class Frog {
    static int frogCount = 0; // Declare and initialize
    // static variable
    public Frog() {
        frogCount += 1; // Modify the value in the constructor
    }
    public static void main (String [] args) {
        new Frog();
        new Frog();
        new Frog();
        System.out.println("Frog count is now " + frogCount);
    }
}
```

#####static method has no dependencies on instance states
you can't use member variables or methods inside statics.

##### override?
static methods can't be overridden because it only pertains to class, not instances, in subclass you can still define an exactly the same method, but that has no relationship with the parent class.

#### interface can't have static methods

Interfaces can’t have static methods, abstract class can.

```java
abstract class A {
    static void test() {} // allowed
}

interface B {
    static void test() {} // not allowed
}
```