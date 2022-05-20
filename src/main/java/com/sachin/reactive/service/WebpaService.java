package com.sachin.reactive.service;

import com.sachin.reactive.client.WebpaClient;
import com.sachin.reactive.response.WebpaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class WebpaService {

    private  static Integer counter  = new Integer(0);


    @Autowired
    WebpaClient webpaClient;

    public Mono<WebpaResponse> getConfig(String deviceId) {
       return Mono.just(deviceId)
                .flatMap(this::getWebpaConfig)
               .doOnNext(i-> {
                   i.setCounter(++counter);
                   System.out.println("request no "+ counter+" and payload "+i);
               })
               .onErrorReturn(WebClientResponseException.class,  WebpaResponse.builder().message("blah").build())
                .subscribeOn(Schedulers.boundedElastic());
    }


    private  Mono<WebpaResponse> getWebpaConfig(String deviceId){
        return webpaClient.getConfig(deviceId)
//                .delayElement(Duration.ofSeconds(5))
                ;
    }
}
