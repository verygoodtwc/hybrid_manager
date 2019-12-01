package com.duwojian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.duwojian.StudentEntity;

import java.util.List;

public interface IStudentService extends IService<StudentEntity> {

    List<StudentEntity> stulist();

    void delStuById(int id);

    void delStuByCid(int id);

    /**
     * 根据ID查询学生对象
     * @param id
     * @return
     */
    StudentEntity selectStuById(Integer id);

    /**
     * 根据ID修改学生信息
     * @param student
     * @return
     */
    int updateStudentByIdSelective(StudentEntity student);
}
