package com.xueyin.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xueyin.demo.entity.Department;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xueyin.demo.entity.DepartmentQueryObject;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xueyin
 * @since 2023-05-25
 */
public interface IDepartmentService extends IService<Department> {
    //条件分页查询
    IPage<Department> conditionPage(DepartmentQueryObject qo);

}
