HTTP Basic Auth
======

###### What is the “realm” in basic authentication
A realm can be seen as an area (not a particular page, it could be a group of pages) for which the credentials are used [ref](http://stackoverflow.com/a/12701139/1338198)

##### prompt on failed auth
```java
res.setHeader("WWW-Authenticate", "Basic realm=\"Please log in\"" );  
res.setHeader("Content-Type", "text/html" );  
res.setStatus(401);  
```