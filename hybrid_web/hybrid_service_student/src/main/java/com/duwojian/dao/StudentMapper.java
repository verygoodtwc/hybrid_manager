package com.duwojian.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.duwojian.StudentEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper extends BaseMapper<StudentEntity> {
    @Delete("delete from student where cid=#{id}")
    void deleteone(@Param("id") int id);
}
