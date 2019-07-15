package com.example.demo.commen.task;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

public class TaskTest2 implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {

    }

    @Mapper
    public interface cronmapper{

        @Select("select from where id")
        public String getCronById(String id);
    }
}
