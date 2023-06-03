package com.xueyin.demo.entity;

import com.xueyin.demo.qo.QueryObject;
import lombok.Data;

@Data
public class DepartmentQueryObject extends QueryObject {
    private String name;
}
