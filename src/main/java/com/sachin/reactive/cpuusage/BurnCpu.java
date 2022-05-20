package com.sachin.reactive.cpuusage;


import com.sachin.reactive.service.FileReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.stream.IntStream;

@Component
public class BurnCpu {


    @Autowired
    FileReaderService fileReaderService;




    @PostConstruct
    private  void  init(){
        int count = Runtime.getRuntime().availableProcessors();

        Runnable runnable = () -> {
//            while (true){
//                int max = 200;
//                for(int i=0;i<max;i++){
//                   System.out.println("factorial of "+i+" is "+factorial(i));
//                }
//                    readFile("/opt/app/file03.txt");
//                try {
//                    Thread.currentThread().sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

//            }
        };
        System.out.println("count -->"+ count);
        IntStream.range(0,count).forEach( i-> {
            new Thread(runnable).start();
        });
    }
    public static BigInteger factorial(int number) {
        BigInteger factorial = BigInteger.ONE;
        for (int i = number; i > 0; i--) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }


    public void readFile(String pathString) {
        Path path = Paths.get(pathString);
        boolean isDocker = Files.exists(path);
        if(!isDocker){
            pathString="/Users/sachinnarang/Documents/workspace/reactiveDeviceService/src/main/resources/file03.txt";
            path = Paths.get(pathString);
        }
        fileReaderService.read(path)
                .delayElements(Duration.ofSeconds(1))
                .subscribe(this::onNext);
    }

    public void onNext(Object o) {
        System.out.println("Thread name : "+Thread.currentThread().getName()+ " Received : "+ o);

    }



}
