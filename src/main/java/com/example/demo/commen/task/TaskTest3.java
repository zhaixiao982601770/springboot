package com.example.demo.commen.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Configuration
//@EnableScheduling
public class TaskTest3 {

  /*  @Async
    @Scheduled(fixedRate = 500)
    public void task1() throws InterruptedException {
        Thread.sleep(2000);
        log.info(Thread.currentThread().getName()+"在执行任务");
    }

    @Async
    @Scheduled(fixedRate = 500)
    public void task2(){
       log.info(Thread.currentThread().getName()+"在执行任务");
    }
*/
}
