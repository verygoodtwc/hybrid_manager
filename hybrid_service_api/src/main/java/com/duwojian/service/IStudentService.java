package com.duwojian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.duwojian.StudentEntity;

import java.util.List;

public interface IStudentService extends IService<StudentEntity> {

    List<StudentEntity> stulist();

    void delStuById(int id);

    void delStuByCid(int id);
}
