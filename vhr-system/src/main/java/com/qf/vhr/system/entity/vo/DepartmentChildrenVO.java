package com.qf.vhr.system.entity.vo;

import com.qf.vhr.system.entity.Department;

import java.util.List;

/**
 * @Author 李小晖
 * @Date 2022/7/28 14:28
 * @Version IDEA 2022.1.1
 */

public class DepartmentVO extends Department {
    List<Department> children;

    public List<Department> getChildren() {
        return children;
    }

    public void setChildren(List<Department> children) {
        this.children = children;
    }
}
