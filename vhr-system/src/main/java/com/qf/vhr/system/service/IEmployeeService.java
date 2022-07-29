package com.qf.vhr.framework.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qf.vhr.framework.entity.Employee;
import com.qf.vhr.framework.result.RespBean;
import com.qf.vhr.framework.result.RespBeanPage;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author 李小晖
 * @Date 2022/7/28 20:00
 * @Version IDEA 2022.1.1
 */

public interface IEmployeeService extends IService<Employee> {
    RespBeanPage getEmployeesByPage(Integer currentPageNo, Integer pageSize);

    int addEmployee(Employee employee);

    int deleteEmployeeById(Integer id);

    RespBean importEmployeeData(MultipartFile file);
}
