package com.duwojian.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.duwojian.ClassEntity;
import com.duwojian.dao.ClassMapper;
import com.duwojian.service.IClassService;
import com.duwojian.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ClassServiceImpl extends ServiceImpl<ClassMapper, ClassEntity> implements IClassService {
    @Autowired
    private ClassMapper classMapper;
    @Reference
    private IStudentService studentService;
    @Override
    public ClassEntity queryById(Integer cid) {
        return classMapper.selectById(cid);
    }

    @Override
    public List<ClassEntity> classlist() {
        return classMapper.selectList(null);
    }

    @Override
    public void delClassByid(int id) {
        classMapper.deleteById(id);

        studentService.delStuByCid(id);
    }
}
