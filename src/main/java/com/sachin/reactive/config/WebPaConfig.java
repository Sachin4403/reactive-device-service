//package com.sachin.reactive.config;
//
//
//import com.sachin.reactive.handler.WebpaHandler;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.reactive.function.server.RouterFunction;
//import org.springframework.web.reactive.function.server.RouterFunctions;
//
//@Configuration
//public class WebPaConfig {
//
//
//    @Autowired
//    WebpaHandler webpaHandler;
//
//
//
//    @Bean
//    public RouterFunction routerFunction(){
//        return RouterFunctions.route()
//                .GET("device/{deviceId}/config",webpaHandler::configHandler)
//                .build();
//    }
//}
