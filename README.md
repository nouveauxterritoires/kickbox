# kickbox

The Java API for the <a href="https://docs.kickbox.com/docs/using-the-api">Kickbox.com</a> service.

# How to use

Simple validate:

```
 KickBoxApi kickBoxApi = new KickBoxApi("KEY");
 boolean valid = kickBoxApi.verify("your_email@gmail.com");
```

Validate with response:

```
 KickBoxApi kickBoxApi = new KickBoxApi("KEY");
 ExtendedKickBoxResponse response = kickBoxApi.verifyWithResponse("your_email@gmail.com");
```
Where ExtendedKickBoxResponse is response structure:
 
```
public class ExtendedKickBoxResponse {
	private String messsage;
	private int code;
	private KickBoxResponse kickboxResponse;
}
```
And KickBoxResponseStructure:

```
 public class KickBoxResponse {
     public String result;
     public String reason;
     public boolean role;
     public boolean free;
     public boolean disposable;
     public boolean accept_all;
     public String did_you_mean;
     public double sendex;
     public String email;
     public String user;
     public String domain;
     public boolean success;
     private String message;
}
```

# Build for Java application

```
mv src/main/filters/dev-example.properties src/main/filters/dev.properties
```
Add your API_KEY (sandbox mode) in dev.properties at the variable 'api.key.sandbox'

And now, package the application:

 ```
 mvn clean package
 ```
