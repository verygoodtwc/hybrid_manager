package com.duwojian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.duwojian.ClassEntity;

import java.util.List;

public interface IClassService extends IService<ClassEntity> {


    ClassEntity queryById(Integer cid);

    List<ClassEntity> classlist();

    void delClassByid(int id);

    /**
     * 根据班级ID查询学生信息
     * @param cid
     * @return
     */
    ClassEntity selectClassById(Integer cid);

    /**
     * 修改班级人数加1
     * @param
     * @return
     */
    int updatePeopleById(ClassEntity classEntity);

}
