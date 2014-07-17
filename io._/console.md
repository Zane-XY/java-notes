Console
======

Before Java 6, you might want to do this:

```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
System.out.println("Username: ");
while ((username = br.readLine()) == null) {
    System.out.println(username);
}
```
the above code can't handle password input.

Since Java 6, you can write:
```java
Console console = System.console();
String username = console.readLine("Username: ");
```
note, `System.console()` may return null if it's running in a environment without console, i.e. IDEs.

