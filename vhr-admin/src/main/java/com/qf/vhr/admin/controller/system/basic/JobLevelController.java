package com.qf.vhr.admin.controller.system.basic;

import com.qf.vhr.framework.respEnum.JobLevelEnum;
import com.qf.vhr.framework.respEnum.JobLevelType;
import com.qf.vhr.framework.result.RespBean;
import com.qf.vhr.system.entity.Joblevel;
import com.qf.vhr.system.service.IJoblevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;

/**
 * @Author 李小晖
 * @Date 2022/7/27 16:37
 * @Version IDEA 2022.1.1
 */
@RestController
@RequestMapping("/system/basic/jobLevel")
public class JobLevelController {

    @Autowired
    IJoblevelService joblevelService;

    @GetMapping("/allEnum")
    public RespBean getAllJobLevelEnum() {
        List<JobLevelType> list = new ArrayList<>();
        for (JobLevelEnum jobLevelEnum : EnumSet.allOf(JobLevelEnum.class)) {
            JobLevelType jobLevelType = new JobLevelType();
            jobLevelType.setLevelCode(jobLevelEnum.levelCode);
            jobLevelType.setJobLevelName(jobLevelEnum.JobLevelName);
            list.add(jobLevelType);
        }
        return RespBean.ok("查询所有职称枚举成功", list);
    }
}
