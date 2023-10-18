package com.example.rpc.service;

import com.example.rpc.services.PingRequest;
import com.example.rpc.services.PingResponse;
import com.example.rpc.services.PingServiceGrpc;
import io.grpc.stub.StreamObserver;

public class PingServiceImpl extends PingServiceGrpc.PingServiceImplBase {

    @Override
    public void getPing(PingRequest request, StreamObserver<PingResponse> responseObserver) {
        System.out.println(request + " " + responseObserver);
        //super.getPing(request, responseObserver);
        System.out.println(request + " " + responseObserver);

        PingResponse.Builder builder = PingResponse.newBuilder()
                .setMessage("Pong!");

        var r = builder.build();
        responseObserver.onNext(r);
        responseObserver.onCompleted();
    }
}
