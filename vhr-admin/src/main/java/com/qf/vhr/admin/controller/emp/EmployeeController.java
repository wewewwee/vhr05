package com.qf.vhr.admin.controller.emp;

import com.alibaba.excel.EasyExcel;
import com.qf.vhr.framework.result.RespBean;
import com.qf.vhr.framework.result.RespBeanPage;
import com.qf.vhr.system.entity.Position;
import com.qf.vhr.system.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @Author 李小晖
 * @Date 2022/7/28 19:49
 * @Version IDEA 2022.1.1
 */
@RestController
@RequestMapping("")
public class EmpController {

    @Autowired
    IPositionService positionService;

    @GetMapping("/")
    public RespBeanPage getPositionsByPage(@RequestParam(defaultValue = "1") Integer currentPageNo, @RequestParam(defaultValue = "30")Integer pageSize){
        return positionService.getPositionsByPage(currentPageNo,pageSize);

    }

    @PostMapping("/")
    public RespBean AddPositions(@RequestBody Position position){
        int num =   positionService.addPosition(position);
        if (num == 1){
            return RespBean.ok("添加成功");
        } else if (num == -1) {
            return RespBean.error("职位名已经存在，添加失败");
        }
        return RespBean.error("添加失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deletePositions(@PathVariable("id") Integer id){
        int num = positionService.deletePositionById(id);
        if (num == 1){
            return  RespBean.ok("删除成功");
        }else if (num == -1){
            return RespBean.error("要删除的数据不存在，删除失败");
        }
        return RespBean.error("未知错误，删除失败");
    }

    @PutMapping("/")
    public RespBean UpdatePosition(@RequestBody Position position){
        if (positionService.updateById(position)){
            return RespBean.ok("更新修改成功");
        }
        return RespBean.error("更新修改失败");
    }

    /**  Excel 表格下载
     *
     *  文件下载（失败了会返回一个有部分数据的Excel）
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link }
     * <p>
     * 2. 设置返回的 参数
     * <p>
     * 3. 直接写，这里注意，finish的时候会自动关闭OutputStream,当然你外面再关闭流问题不大
     */
    @GetMapping("/exportPos")
    public void download(HttpServletResponse response) throws IOException {
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("职工基本信息表", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), Position.class).sheet("模板").doWrite(positionService.list());
    }

    /**
     * Excel 表格 文件上传
     *
     */
    @PostMapping("/import")
    public RespBean importPositionData(MultipartFile file){
        return positionService.importPositionData(file);
    }

}
