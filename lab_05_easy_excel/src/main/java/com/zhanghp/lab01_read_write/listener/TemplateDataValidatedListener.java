package com.zhanghp.lab01_read_write.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.read.listener.ReadListener;
import com.zhanghp.utils.EasyExcelUtils;

import java.lang.reflect.ParameterizedType;
import java.util.Map;

/**
 * @author zhanghp
 * @date 2023/8/23 17:35
 */
public class TemplateDataValidatedListener<T> implements ReadListener<T> {
    @Override
    public void invokeHead(Map<Integer, ReadCellData<?>> headMap, AnalysisContext context) {
        Class childClazz = this.getClass(); //子类字节码对象
        //得到父类的字节码BaseDaoImpl的字节码 ， 这份字节码上带有泛型数据
        /**
         * 虽然这个方法，返回值说的是Type ，
         * 但是其实返回的是ParameterizedType的实现类类型。
         * 所以我们使用ParameterizedTypeImpl接口来接收。
         */
        ParameterizedType genericSuperclass = (ParameterizedType) childClazz.getGenericSuperclass();
        Class clazz = (Class) genericSuperclass.getActualTypeArguments()[0];
        EasyExcelUtils.checkTemplateTitle(headMap, clazz);
    }

    @Override
    public void invoke(T t, AnalysisContext analysisContext) {

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
    }
}
