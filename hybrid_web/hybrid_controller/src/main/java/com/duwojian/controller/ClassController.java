package com.duwojian.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.duwojian.ClassEntity;
import com.duwojian.service.IClassService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("class")
public class ClassController {
    @Reference
    private IClassService classService;

    @RequestMapping("toadd")
    private String toadd(){
        return "classadd";
    }

    @RequestMapping("add")
    private String add(ClassEntity classEntity){
        boolean save = classService.save(classEntity);
        if (save){
            return "ok";
        }
        return null;
    }
}
