package com.duwojian.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.duwojian.ClassEntity;
import com.duwojian.StudentEntity;
import com.duwojian.service.IClassService;
import com.duwojian.service.IStudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("student")
public class StudentController {

    @Reference
    private IStudentService studentService;
    @Reference
    private IClassService classService;

    @RequestMapping("toadd")
    private String  toadd(Model model){
        List<ClassEntity> list = classService.list();
        model.addAttribute("list",list);
        return "studentadd";
    }
    @RequestMapping("add")
    private String add(StudentEntity studentEntity){
        System.out.println(studentEntity);
        System.out.println(studentService);
        boolean save = studentService.save(studentEntity);
        if(save){
            ClassEntity byId = classService.getById(studentEntity.getCid());
            int people=byId.getPeople()+1;
            byId.setPeople(people);
            classService.updateById(byId);
            return "ok";
        }
        return null;
    }
}
