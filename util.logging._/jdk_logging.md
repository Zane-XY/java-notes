JDK logging
======

##### obtain the logger
```java
private final static Logger logger = Logger.getLogger(Mailer.class.getName());
```

##### load logging configs
There is a single global LogManager object, so you can call it upon your app start.
```java
LogManager manager = LogManager.getLogManager();
manager.readConfiguration(Config.class.getClassLoader().getResourceAsStream("logging.properties"));
```
##### logging.properties [ref](http://docs.oracle.com/cd/E19159-01/819-7753/gcblo/index.html)
```
handlers= java.util.logging.ConsoleHandler
.level=INFO
java.util.logging.ConsoleHandler.level = INFO

#disable data line
java.util.logging.SimpleFormatter.format=%4$s: %5$s [%1$tc]%n
```
