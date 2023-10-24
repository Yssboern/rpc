package com.example.rpc.service;

import com.example.rpc.services.PingRequest;
import com.example.rpc.services.PingResponse;
import com.example.rpc.services.PingServiceGrpc;
import io.grpc.stub.StreamObserver;

public class PingServiceImpl extends PingServiceGrpc.PingServiceImplBase {

    @Override
    public void getPing(PingRequest request, StreamObserver<PingResponse> responseObserver) {

        PingResponse.Builder builder = PingResponse
                .newBuilder()
                .setMessage("Pong!");

        System.out.println("Server received " + request.getMessage() + " sending response: Pong!");

        var response = builder.build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
