Properties
======

# load config
```java
public class Config {
    private static Properties prop = new Properties();

    static {
        try {
            prop.load(new FileInputStream("src/main/resources/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return String.valueOf(prop.get(key));
    }
}

```
