# gRPC

## Server side

https://github.com/charroux/gRPC/tree/main/carstat

### Service definition in Proto Buffers language

https://github.com/charroux/gRPC/blob/main/carstat/src/main/proto/carservice.proto

### Server side implementation

https://github.com/charroux/gRPC/blob/main/carstat/src/main/java/com/charroux/carstat/CarRentalServiceImpl.java

### Build and run

Open the project in Intellij or import this project as a Gradle project in Eclipse.

Build the project within Eclipse or Intellij.

Look at the generated code in the build folder.

Launch the main program at the server side: https://github.com/charroux/gRPC/blob/main/carstat/src/main/java/com/charroux/carstat/CarstatApplication.java

### Build and run with Gradle

./gradlew build

java -jar build/libs/carstat-0.0.1-SNAPSHOT.jar

### Build and run with Docker

docker build -t carstat .    

docker run -p 8080:8080 -t carstat

## Client side

https://github.com/charroux/gRPC/tree/main/CarServiceGrpc

### Build and run

Open the project in Intellij or import this project as a Gradle project in Eclipse.

Build the project within Eclipse or Intellij.

### Make a single request from the client, response as a stream (sequence of messages))

https://github.com/charroux/CarServiceGrpc/blob/main/src/main/java/carservice/GrpcClientReturnStream.java

### The client sends a sequence of messages then waits for an asynchronous response

https://github.com/charroux/CarServiceGrpc/blob/main/src/main/java/carservice/GrpcClientSendStream.java

### The client receive a dynamic response each time the server receives a request

https://github.com/charroux/CarServiceGrpc/blob/main/src/main/java/carservice/GrpcClientSendStreamReturnStream.java
