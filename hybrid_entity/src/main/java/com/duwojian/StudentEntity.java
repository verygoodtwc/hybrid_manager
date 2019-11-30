package com.duwojian;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("Student")
public class StudentEntity extends BaseEntity{
    private String sname;
    private Integer age;
    private Integer cid;
    @TableField(exist = false)
    private ClassEntity classEntity;
}
