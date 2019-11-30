package com.duwojian.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.duwojian.StudentEntity;
import com.duwojian.dao.StudentMapper;
import com.duwojian.service.IStudentService;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, StudentEntity> implements IStudentService {
}
