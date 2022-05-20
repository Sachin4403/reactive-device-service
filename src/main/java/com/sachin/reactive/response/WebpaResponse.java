package com.sachin.reactive.response;


import lombok.*;

import java.util.Date;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WebpaResponse {


    private Date date = new Date();
    int code;
    String message;
    long timestamp;
    long counter;
}
