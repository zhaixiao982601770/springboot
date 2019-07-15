package com.example.demo.commen.task;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Configuration
//@EnableScheduling       //开启定时任务
@Slf4j
public class TaskTest1 {

    //  @Scheduled(cron = "0/5 * * * * *")
/*
    @Scheduled(fixedRate = 5000)
    public void test(){
        log.info("我是第一个定时");
    }*/
}
