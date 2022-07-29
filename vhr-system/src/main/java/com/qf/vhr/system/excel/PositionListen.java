package com.qf.vhr.framework.excel;


import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;

import javax.swing.text.Position;

/**
 * @Author 李小晖
 * @Date 2022/7/28 10:44
 * @Version IDEA 2022.1.1
 */

public class PositionListen implements ReadListener<Position> {
     @Override
     public void invoke(Position position, AnalysisContext analysisContext) {
          
     }

     @Override
     public void doAfterAllAnalysed(AnalysisContext analysisContext) {

     }
}
