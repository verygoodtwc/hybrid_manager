package com.duwojian;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("cclass")
public class ClassEntity extends BaseEntity{
    private String cname;
    private Integer people;
}
