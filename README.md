
start program in a console with gradle bootRun
* use embedded gradlew or gradlew.bat if no gradle installed locally
```
gradle botRun
```

check gradle jobs in group: grcp clients to run them from IDE UI or use cli commands:
* ```
  gradle javaClient
  ```
* ```
  gradle jsClient
  ```
* ```
  gradle pyClient
  ```

expected result in spring boot terminal:
```angular2html
Server received Ping! [js client] sending response: Pong!
Server received Ping! [python client] sending response: Pong!
Server received Ping! [springboot client] sending response: Pong!
Java client received response: Pong!
```

also client should report received 'Pong!' msg to their terminal

# gRPC part (2 point)
{ "message": "Ping" } And responses with something like this (feel free to add more fields){ "message": "Pong" }

* Create a simple Java gRPC client application that sends a request to the simple server (share the same proto file), gets a response, and prints it.
* Create a simple gRPC client application in any other language you like that sends a request to the simple server, gets a
  response, and prints it. Use the same proto file.
* Start a server and try to communicate with it using the clients you just wrote.

