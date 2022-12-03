package org.example;

import com.google.protobuf.Empty;
import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.helloworld.*;

import java.util.Iterator;

public class GrpcClient {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        GreeterGrpc.GreeterBlockingStub stub
                = GreeterGrpc.newBlockingStub(channel);

        HelloResponse helloResponse = stub.sayHello(HelloRequest.newBuilder()
                .setName("Benoit")
                .build());

        String message = helloResponse.getMessage();
        System.out.println(message);

        Iterator<Car> cars = stub.getCars(GetCarsRequest.newBuilder().build());
        while(cars.hasNext()){
            Car car = cars.next();
            System.out.println(car);
        }


        channel.shutdown();
    }
}
