package com.zhanghp.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.zhanghp.enums.SexEnum;
import com.zhanghp.lab02_converter.annotation.ExcelEnum;
import com.zhanghp.lab02_converter.converter.ExcelEnumConverter;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * lab02 用到的对象
 *
 * @author zhanghp
 * @date 2023/7/12 14:19
 */
@Data
@EqualsAndHashCode
@ColumnWidth(10)
public class EnumHandleData {
    @ExcelProperty(value = "姓名", index = 0)
    private String name;

    @ExcelProperty(value = "性别", index = 1, converter = ExcelEnumConverter.class)
    @ExcelEnum(enumClass = SexEnum.class)
    private Integer sex;

    @ExcelProperty(value = "出生日期", index = 2)
    @DateTimeFormat("yyyy/MM/dd")
    // 不会因在类上的设定，而导致不生效
    @ColumnWidth(20)
    private Date birth;

    @ExcelProperty(value = "身高", index = 3)
    private Double height;

}
