package com.example.rpc.service;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class PingServer {

    @Bean
    Server getServer() throws IOException {
        Server server = ServerBuilder.forPort(50051)
                .addService(new PingServiceImpl())
                .build();
        return server.start();
    }
}
