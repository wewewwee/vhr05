package com.qf.vhr.system.entity.vo;

import com.qf.vhr.system.entity.Menu;

import java.util.List;

/**
 * @Author 李小晖
 * @Date 2022/7/25 20:17
 * @Version IDEA 2022.1.1
 */

public class MenuVO extends Menu {

    private List<Menu> children;

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

}
