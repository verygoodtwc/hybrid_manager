package com.duwojian.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.duwojian.StudentEntity;
import com.duwojian.service.IStudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("student")
public class StudentController {

    @Reference
    private IStudentService studentService;

    @RequestMapping("toadd")
    private String  toadd(Model model){
        return "studentadd";
    }
    @RequestMapping("add")
    private String add(StudentEntity studentEntity){
        System.out.println(studentEntity);
        System.out.println(studentService);
        boolean save = studentService.save(studentEntity);
        if(save){
            return "ok";
        }
        return null;
    }
}
