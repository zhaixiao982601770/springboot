package com.example.demo;

import com.example.demo.config.SystemConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@MapperScan("com.example.demo.dao")
@SpringBootApplication
@EnableScheduling       //关掉定时
public class DemoApplication {

    @Value("{spring.profiles.active}")
    private String info;

    @Autowired
    private Environment environment;

    @Autowired
    private SystemConfig config;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @ResponseBody
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){

        System.out.println(1/0);
        return  config.toString();
    }
}
