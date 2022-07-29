package com.qf.vhr.framework.respEnum;

import lombok.AllArgsConstructor;

import java.util.Objects;

/**
 * @Author 李小晖
 * @Date 2022/7/27 16:51
 * @Version IDEA 2022.1.1
 */
@AllArgsConstructor
public enum JobLevelEnum {
    /** 职称模型
     *
     */
    /**
     *
     */
    FIRST_HIGH(1, "正高级"),
    /**
     *
     */
    SECOND_HIGH(2, "副高级"),
    /**
     *
     */
    BASIC_HIGH(3, "初级"),
    /**
     *
     */
    MIDDLE_HIGH(4, "中级");

    public final Integer code;
    public final String JobLevelName;

    public static String getGoodsName(Integer code) {
        if (Objects.nonNull(code)) {
            for (JobLevelEnum value : values()) {
                if (value.code.equals(code)) {
                    return value.JobLevelName;
                }
            }
        }
        return null;
    }
}

