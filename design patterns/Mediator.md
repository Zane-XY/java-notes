Mediator
======

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