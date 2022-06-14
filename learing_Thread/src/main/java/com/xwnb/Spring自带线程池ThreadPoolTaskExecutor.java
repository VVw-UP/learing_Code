package com.xwnb;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author SB_AXN
 */
@Component
@EnableAsync
public class Spring自带线程池ThreadPoolTaskExecutor {
    public static void main(String[] args) {
        new Spring自带线程池ThreadPoolTaskExecutor().testScheduleTask();
        new Spring自带线程池ThreadPoolTaskExecutor().testAsyn();
    }

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Async
    @Scheduled(fixedRate = 2000)
    public void testScheduleTask() {
        try {
            Thread.sleep(6000);
            System.out.println("Spring1自带的线程池" + Thread.currentThread().getName() + "-" + sdf.format(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Async
    @Scheduled(cron = "*/2 * * * * ?")
    public void testAsyn() {
        try {
            Thread.sleep(1000);
            System.out.println("Spring2自带的线程池" + Thread.currentThread().getName() + "-" + sdf.format(new Date()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}