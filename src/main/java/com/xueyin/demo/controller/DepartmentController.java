package com.xueyin.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xueyin.demo.common.Result;
import com.xueyin.demo.entity.Department;
import com.xueyin.demo.entity.DepartmentQueryObject;
import com.xueyin.demo.qo.QueryObject;
import com.xueyin.demo.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xueyin
 * @since 2023-05-25
 */
@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private IDepartmentService departmentService;

    //增加    post
    //code 200  message:操作成功    data:{}
    @PostMapping("save")
    public Result save(@RequestBody Department department){
//        System.out.println(department);
        departmentService.save(department);

        return Result.success("操作成功");
    }

    //修改    put
    @PutMapping("update")
    public Result update(@RequestBody Department department){
        departmentService.updateById(department);
        return Result.success("修改成功");
    }

    //根据id删除    delete
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Long id){
        departmentService.removeById(id);
        return Result.success("删除成功");
    }

    //根据id查询    get
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id){
        Department department = departmentService.getById(id);
        return Result.success("查询成功",department);
    }

    //查询所有    get
    @GetMapping("list")
    public Result list(){
        List<Department> list = departmentService.list();
        return Result.success("查询成功",list);
    }

    //分页查询
    @GetMapping("page")
    public Result page(QueryObject qo){
        IPage<Department> page = new Page<>(qo.getCurrentPage(), qo.getPageSize());
        page = departmentService.page(page);
        return Result.success("查询成功",page);
    }

    //条件分页查询
    @GetMapping("conditionPage")
    public Result conditionPage(DepartmentQueryObject qo){
        IPage<Department> page = departmentService.conditionPage(qo);
        return Result.success("查询成功",page);
    }
}

