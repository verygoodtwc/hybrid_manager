package com.duwojian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.duwojian.ClassEntity;

import java.util.List;

public interface IClassService extends IService<ClassEntity> {


    ClassEntity queryById(Integer cid);

    List<ClassEntity> classlist();

    void delClassByid(int id);
}
