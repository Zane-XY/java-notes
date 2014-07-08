URLConnection
======

#### Base64Encoding in JDK before Java 8

```java
import javax.xml.bind.DatatypeConverter;
String authEncoding = DatatypeConverter.printBase64Binary((name + ":" + pass).getBytes());
```

#### bypass HTTP Basic Authentication
`authEncoding` is a pair of  `name:pass` in Base64 encoding:

```java

URL url = new URL(urlStr);
HttpURLConnection conn = (HttpURLConnection) url.openConnection();
conn.setRequestProperty("Authorization", "Basic " + authEncoding);
```

#### read response body
```java
in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
String line;
while ((line = in.readLine()) != null) {
	r.append(line);
}
```

#### get response code

this can be done directly through `URLConnection`.
