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
    @RequestMapping("stulist")
    public String stulist(Model model){
        List<StudentEntity> studentlist=studentService.stulist();
        model.addAttribute("studentlist",studentlist);
        System.out.println("所有学生总数："+studentlist.size());
        return "stulist";
    }
    @RequestMapping("delStu")
    public String delStu(int id){
        studentService.delStuById(id);
        return "redirect:/student/stulist";
    }

    /**
     * 跳转修改学生信息页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("toModifyStu")
    public String toModifyStu(Integer id,Model model){
        StudentEntity student=studentService.selectStuById(id);
        //查询学生对应班级信息
        ClassEntity classEntity = classService.selectClassById(student.getCid());
        student.setClassEntity(classEntity);
        model.addAttribute("stu",student);

        return "student/modify_stu";
    }

    /**
     * 修改学生信息
     * @param student
     * @return
     */
    @RequestMapping("modifyStu")
    public String modifyStu(StudentEntity student,Integer cid0){
        System.out.println("修改后的信息"+student);
        System.out.println("旧班级："+cid0);
        //修改学生表信息
        studentService.updateStudentByIdSelective(student);
        //如果新旧班级不一样
        Integer cid = student.getCid();
        if(cid!=cid0){
            //新班级人数加1
            ClassEntity classEntity = classService.selectClassById(cid);
            classEntity.setPeople(classEntity.getPeople()+1);
            classService.updatePeopleById(classEntity);
            //旧班级人数减1
            ClassEntity classEntity1 = classService.selectClassById(cid0);
            classEntity1.setPeople(classEntity1.getPeople()-1);
            classService.updatePeopleById(classEntity1);
        }

        return "redirect:/student/stulist";
    }
}
