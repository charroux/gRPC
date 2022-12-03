package org.example;

import com.google.protobuf.Empty;
import io.grpc.helloworld.*;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;

public class GreeterImpl extends GreeterGrpc.GreeterImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        String greeting = new StringBuilder()
                .append("Hello, ")
                .append(request.getName())
                .toString();

        HelloResponse response = HelloResponse.newBuilder()
                .setMessage(greeting)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getCars(GetCarsRequest request, StreamObserver<Car> responseObserver) {
        for (int i = 1; i <= 5; i++) {
            Car car = Car.newBuilder()
                    .setPrice(100)
                    .setBrand("Ferrari")
                    .setPlateNumber("AA" + i)
                    .build();
            responseObserver.onNext(car);
        }
    }
/*
    @Override
    public void getCars(Empty request, StreamObserver<Car> responseObserver) {
        for (int i = 1; i <= 5; i++) {
            Car car = Car.newBuilder()
                    .setPrice(100)
                    .setBrand("Ferrari")
                    .setPlateNumber("AA" + i)
                    .build();
            responseObserver.onNext(car);
        }
    }
*/
}
