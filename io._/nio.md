NIO
======

#### Path

##### file protocal
```
scala> Paths.get(new URI("""file:///apps/""")).resolve("bin").resolve("java")
res17: java.nio.file.Path = \apps\bin\java
```
##### join path string
```
scala> Paths.get("/apps", "bin", "java")
res18: java.nio.file.Path = \apps\bin\java
```

#### Files

##### create directories

```java
if (Files.notExists(path)) {
    Files.createDirectories(path);
}
```

