package com.example.rpc.client;

import com.example.rpc.services.PingRequest;
import com.example.rpc.services.PingResponse;
import com.example.rpc.services.PingServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

@Service
public class PingClient {

    public static void main(String[] args) {
        System.out.println("Manual client received response: " + new PingClient().sendPing());
    }

    public String sendPing() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("127.0.0.1", 50051)
                .usePlaintext()
                .build();

        PingServiceGrpc.PingServiceBlockingStub stub = PingServiceGrpc.newBlockingStub(channel);
        PingRequest request = PingRequest.newBuilder()
                .setMessage("Ping! [springboot client]")
                .build();

        PingResponse response = stub.getPing(request);
        System.out.println("Java client received response: " + response.getMessage());
        channel.shutdown();
        return response.getMessage();
    }
}
