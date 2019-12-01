package com.duwojian.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.duwojian.StudentEntity;
import com.duwojian.dao.StudentMapper;
import com.duwojian.service.IClassService;
import com.duwojian.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, StudentEntity> implements IStudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Reference
    private IClassService classService;
    @Override
    public List<StudentEntity> stulist() {
        List<StudentEntity> studentList = studentMapper.selectList(null);
        for (StudentEntity student : studentList) {
            student.setClassEntity(classService.queryById(student.getCid()));
        }
        return studentList;
    }

    @Override
    public void delStuById(int id) {
        studentMapper.deleteById(id);
    }

    @Override
    public void delStuByCid(int id) {
        studentMapper.deleteone(id);
    }

    /**
     * 根据学生ID查询学生对象
     * @param id
     * @return
     */
    @Override
    public StudentEntity selectStuById(Integer id) {
        return studentMapper.selectById(id);
    }

    /**
     * 根据学ID修改班级人数
     * @param student
     * @return
     */
    @Override
    public int updateStudentByIdSelective(StudentEntity student) {
        return studentMapper.updateById(student);
    }
}
