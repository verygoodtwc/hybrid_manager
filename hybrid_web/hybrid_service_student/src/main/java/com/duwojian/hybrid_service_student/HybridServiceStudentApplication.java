package com.duwojian.hybrid_service_student;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@DubboComponentScan("com.duwojian.service.impl")
@MapperScan("com.duwojian.dao")
public class HybridServiceStudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(HybridServiceStudentApplication.class, args);
    }

}
