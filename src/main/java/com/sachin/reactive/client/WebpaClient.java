package com.sachin.reactive.client;

import com.sachin.reactive.response.WebpaResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Component
public class WebpaClient {


    private final WebClient webClient;

    public WebpaClient(@Value("${webpa.service.url}") String url) {
        this.webClient = WebClient
                .builder()
                .baseUrl(url)
                .build();
    }


    public Mono<WebpaResponse> getConfig(String deviceId){
        return
                this.webClient
                        .get()
                        .uri("/device/{deviceId}/config",deviceId)
                        .exchangeToMono(clientResponse -> clientResponse.bodyToMono(WebpaResponse.class));
//                        .map(webpaResponse -> {
//                            if(webpaResponse.getErrorCode() != 530){
//                                throw  new RuntimeException("statue code is not 530");
//                            }
//                            else{
//                                return webpaResponse;
//                            }
//                        });




    }
}
