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

[config via Java](http://www.journaldev.com/977/java-logging-api-tutorial-examples-logger-levels-handlers-formatters-filters)

##### logging.properties [ref](http://docs.oracle.com/cd/E19159-01/819-7753/gcblo/index.html)
more about formatter [link](http://docs.oracle.com/javase/7/docs/api/java/util/logging/SimpleFormatter.html#format(java.util.logging.LogRecord))
FileHandler name pattern: [link](http://docs.oracle.com/javase/7/docs/api/java/util/logging/FileHandler.html)

```
handlers= java.util.logging.ConsoleHandler,java.util.logging.FileHandler

java.util.logging.FileHandler.pattern   = %u.%g.log
java.util.logging.FileHandler.limit = 50000
java.util.logging.FileHandler.count = 1
java.util.logging.FileHandler.formatter = java.util.logging.SimpleFormatter

java.util.logging.ConsoleHandler.level = INFO
java.util.logging.SimpleFormatter.format=%4$s: %5$s %n

```
