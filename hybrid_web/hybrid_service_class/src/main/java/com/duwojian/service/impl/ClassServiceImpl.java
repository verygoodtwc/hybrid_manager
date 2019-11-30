package com.duwojian.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.duwojian.ClassEntity;
import com.duwojian.dao.ClassMapper;
import com.duwojian.service.IClassService;
@Service
public class ClassServiceImpl extends ServiceImpl<ClassMapper, ClassEntity> implements IClassService {
}
