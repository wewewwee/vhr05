package com.qf.vhr.framework.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.vhr.framework.entity.Employee;
import com.qf.vhr.framework.mapper.EmployeeMapper;
import com.qf.vhr.framework.result.RespBean;
import com.qf.vhr.framework.result.RespBeanPage;
import com.qf.vhr.framework.service.IEmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * @Author 李小晖
 * @Date 2022/7/28 20:01
 * @Version IDEA 2022.1.1
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper,Employee> implements IEmployeeService {


    @Override
    public int addEmployee(Employee employee) {
        QueryWrapper<Employee> qw = new QueryWrapper<>();
        qw.lambda().eq(Employee::getName,employee.getName());
        Employee one = getOne(qw);
        if (one != null){
            // 说明职位已经存在
            return -1;
        }
        employee.setCreateDate(LocalDateTime.now());
        employee.setEnabled(true);
        return save(employee) ? 1 : -2;
    }

    @Override
    public int deleteEmployeeById(Integer id) {
        Employee employee = getById(id);
        if (employee == null){
            // 说明要删除的数据不存在
            return -1;
        }
        return removeById(id) ? 1 : -2;
    }

    @Override
    public RespBean importEmployeeData(MultipartFile file) {
        try {
            EasyExcel.read(file.getInputStream(),Employee.class,new EmployeeListen(this)).sheet().doRead();
            return RespBean.ok("Excel 表格导入成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return RespBean.error("Excel 表格导入失败");
    }

    @Override
    public RespBeanPage getEmployeesByPage(Integer currentPageNo, Integer pageSize) {
        Page<Employee> page = page(Page.of(currentPageNo,pageSize));
        return new RespBeanPage(page.getTotal(),page.getRecords());
    }
}
