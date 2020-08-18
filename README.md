# ShadowBanAPIExample
A example how to use the ShadowAPI for ShadowBan

The API is based on a token wich only you and the server knows.
To request data from our database you have to create a SocketSender in you coding language.
To connect to our servers use this information:
```java
host: betterproject.net
port: 9999
```

The you have to send a socket with the follwing information:
```java
AUTH_KEY=YOURKEYHERE
```
in java it should look like this:
```java
 SocketSender socketSender = new SocketSender("AUTH_KEY=YOURKEYHERE", "betterproject.net", 9999);
```
If you are using java you can use our socketsender.


If the AUTH_KEY you gave the server is correct he will try to send a socket to your server.
NOTE: Only public servers will work. Your PC will automaticly block any connection by our server.

The server will return the follwing string:
```java
CONNECTED (if you AUTH_KEY is correct)
ERROR_ALREADY_CONNECTED (if you are already connected)
ERROR_AUTH_KEY_NOT_VALID (if your AUTH_KEY is not valid)
```

NOTE: If you want to let the server know that your insatnce is shutting down send a socket with ```java DISCONNECT``` to the server.
Otherwise the server don't know if you connection is alive or not. So you can't connect to the API anymore until the bot gets restarted.

If the bot accpeted your AUTH_KEY you are ready to request the follwing data:
```java
 API_REQUEST_MEMBER_BANNED=memberId (returns REQUEST_BANNED=true/false. You have to split the string after the = symbol to get a boolean)
 API_REQUEST_MEMBER_TYPE=memberId (returns REQUEST_TYPE=NONE/SPAMMING/BULLYING/RAIDING. You alos have to split it to get a string with the type)
```
