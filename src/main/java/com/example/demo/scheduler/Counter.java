//package com.example.demo.scheduler;
//
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.util.concurrent.atomic.AtomicInteger;
//
//@Component
//public class Counter {
//    private AtomicInteger count = new AtomicInteger(0);
//
//    @Scheduled(fixedDelay = 5)
//    public void scheduled() {
//        System.out.println("scheduled task executed "+ count);
//        this.count.incrementAndGet();
//    }
//
//    public int getInvocationCount() {
//        return this.count.get();
//    }
//}
