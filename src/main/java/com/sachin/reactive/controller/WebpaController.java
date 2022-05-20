package com.sachin.reactive.controller;


import com.sachin.reactive.response.WebpaResponse;
import com.sachin.reactive.service.WebpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("device")
public class WebpaController {

    @Autowired
    WebpaService webpaService;



    @GetMapping("/{deviceId}/config")
    public Mono<ResponseEntity<WebpaResponse>> getConfig(@PathVariable String deviceId){
        System.out.println("request received");
        Mono<WebpaResponse> responseMono = webpaService.getConfig(deviceId);
        return  responseMono.map(i-> ResponseEntity.status(i.getCode()).body(i))
                .onErrorReturn(WebClientResponseException.class, ResponseEntity.badRequest().body(WebpaResponse.builder().message("blah").build()))
                .onErrorReturn(WebClientRequestException.class, ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build())
         ;

    }


}


