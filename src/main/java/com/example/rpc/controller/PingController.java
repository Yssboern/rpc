package com.example.rpc.controller;

import com.example.rpc.client.PingClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PingController {

    @Autowired
    private PingClient pingClient;

    @GetMapping("/ping")
    public String sendPing() {
        return pingClient.sendPing();
    }
}