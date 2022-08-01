package com.zhanghp.common.model.enums;

import com.zhanghp.common.response.CodeEnum;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanghp
 * @date 2022-07-17 23:11
 */
public enum CustomEnum {
    VO("VO", "templates/model/vo.java.vm"),
    RO("RO", "templates/model/ro.java.vm"),
    QO("QO", "templates/model/qo.java.vm"),
    CONVERTER("Converter", "templates/converter/converter.java.vm");

    CustomEnum(String modelSuffix, String path) {
        this.modelSuffix = modelSuffix;
        this.path = path;
    }

    @Getter
    private String modelSuffix;

    @Getter
    private String path;

    public static List<String> getModel(){
        List<String> result = new ArrayList<>();
        CustomEnum[] values = CustomEnum.values();
        for (CustomEnum it : values) {
            result.add(it.getModelSuffix());
        }
        return result;
    }

}
