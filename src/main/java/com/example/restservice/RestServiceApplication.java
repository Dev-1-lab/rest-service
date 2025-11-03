package com.example.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
public class RestServiceApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(RestServiceApplication.class, args);
         class UnsafeCounter {
//            private long counter=0;
            private final AtomicLong counter=new AtomicLong();
            public   void incriment(){
                counter.incrementAndGet();
            }
            private AtomicLong get(){
                return counter;
            }
        }
        UnsafeCounter counter = new UnsafeCounter();
        Thread[] threads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.incriment();
                }
            });
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("Expected: 100000");
        System.out.println("Actual:   " + counter.get());
    }


}
