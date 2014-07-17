read
======

#### read from classpath
```java
InputStream tmpl = getClass().getClassLoader().getResourceAsStream("tmpl.html");
```

#### from `InputStream` to `String`, the `Scanner` trick
```java
Scanner s = new Scanner(inputStream).useDelimiter("\\A")
return s.hasNext() ? s.next() : "";
```

#### enumerate `InputStream` by line
```java
BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
String line;
while ((line = in.readLine()) != null) {
    ...
}
```
#### lineSeparator
After Java 7 `System.lineSeparator()`
Before Java 7 `System.getProperty("line.separator");`

###### encoding
- Java 7 and later
`java.nio.charset.StandardCharsets`
`StandardCharsets.UTF_8`

- Java 6 
`Charset.defaultCharset()`

###### read file into String
- Java 7 and later
```java
static String readFile(String path, Charset encoding) 
  throws IOException 
{
  byte[] encoded = Files.readAllBytes(Paths.get(path));
  return new String(encoded, encoding);
}
```    
or <br>
```java
List<String> lines = Files.readAllLines(Paths.get(path), encoding);
```
- Java 6
```java
String content = new Scanner(new File("filename")).useDelimiter("\\Z").next();
```
