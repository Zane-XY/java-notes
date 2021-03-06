Mediator
======

- The mediator pattern defines an object that encapsulates how a set of objects interact.
- With the mediator pattern, communication between objects is encapsulated with a mediator object. Objects no longer communicate directly with each other, but instead communicate through the mediator. This reduces the dependencies between communicating objects, thereby lowering the coupling.


![alt text](http://www.javacodegeeks.com/wp-content/uploads/2013/07/mediator-pattern.png "mediator pattern")

##summary
- object interactions through interface
- interface defines interaction contracts
- class constructor takes reference of mediator interface


##The Problem

```java
abstract class User {
    abstract void send(String msg);
    abstract void receive(String msg);
}
```
we have a  `List<User> ` , and we want to let one user send message to all other users.
without mediator:

```java
class Admin extends User {
    protected List<User> users;

    Admin(List<User> users) {
        this.users = users;
    }

    void send(String msg) {
        for (User user : users) {
            user.receive(msg);
        }
    }

    void receive(String msg) {
        System.out.println("received " + msg);
    }
}
```
You can see the problem here is Admin has to maintain a list of Users, if I have a Guest, it also need to maintain a list of other Users, so let's move the babysitting to another object called Mediator:

```java
class Admin extends User {
    protected Mediator mediator;

    Admin(Mediator mediator) {
        this.mediator = mediator;
    }

    void send(String msg) {
        mediator.sendToAll(this, msg);
    }

    @Override
    void receive(String msg) {
        System.out.println("received " + msg);
    }
}
public class Mediator {
    protected List<User> users;

    public Mediator(List<User> users) {
        this.users = users;
    }

    public void sendToAll(User origin, String msg) {
        for (User user : users) {
            if (user != origin)
                user.receive(msg);
        }
    }
}
```
