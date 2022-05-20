//package com.sachin.reactive.handler;
//
//import com.sachin.reactive.response.WebpaResponse;
//import com.sachin.reactive.service.WebpaService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.reactive.function.client.WebClientRequestException;
//import org.springframework.web.reactive.function.client.WebClientResponseException;
//import org.springframework.web.reactive.function.server.ServerRequest;
//import org.springframework.web.reactive.function.server.ServerResponse;
//import reactor.core.publisher.Mono;
//
//@Service
//public class WebpaHandler {
//
//    @Autowired
//    WebpaService webpaService;
//
//    public Mono<ServerResponse> configHandler(ServerRequest serverRequest){
//        System.out.println("received");
//        String deviceId = serverRequest.pathVariable("deviceId");
//        Mono<WebpaResponse> responseMono = webpaService.getConfig(deviceId);
//        return  ServerResponse.ok().body(responseMono,WebpaResponse.class);
//    }
//
//}
