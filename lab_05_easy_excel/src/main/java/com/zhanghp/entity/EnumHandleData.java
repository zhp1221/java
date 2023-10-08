package com.zhanghp.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.zhanghp.enums.SexEnum;
import com.zhanghp.lab02_converter.annotation.ExcelEnum;
import com.zhanghp.lab02_converter.converter.ExcelEnumConverter;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
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
    @ExcelProperty(value = "姓名", index = 3)
    private String name;

    @ExcelProperty(value = "性别", index = 2, converter = ExcelEnumConverter.class)
    @ExcelEnum(enumClass = SexEnum.class)
    private Integer sex;

    @ExcelProperty(value = "出生日期", index = 1)
    @DateTimeFormat("yyyy/MM/dd")
    // 不会因在类上的设定，而导致不生效
    @ColumnWidth(20)
    private Date birth;

    private String in;

    @ExcelProperty(value = "身高", index = 6)
    private Double height;

    public static void main(String[] args) {
        Field[] declaredFields = EnumHandleData.class.getDeclaredFields();
//        insertSort(declaredFields);
//        System.out.println(Arrays.toString(declaredFields));
        List<Field> fields = arrToList(declaredFields);
        insertSort2(fields);
        fields.forEach(System.out::println);


    }

    private static List<Field> arrToList(Field[] fields){
        List<Field> result = new ArrayList<>();
        if (fields == null || fields.length == 0) {
            return result;
        }
        for (Field it : fields) {
            ExcelProperty annotation = it.getAnnotation(ExcelProperty.class);
            if (annotation == null) {
                continue;
            }
            result.add(it);
        }
        return result;
    }
    private static void insertSort(Field[] fields) {
        // 边界条件
        if (fields == null || fields.length == 1) {
            return;
        }
        for (int i = 0; i < fields.length; i++) {
            ExcelProperty cur = fields[i].getAnnotation(ExcelProperty.class);
            for (int j = 0; j < i; j++) {
                ExcelProperty next = fields[j].getAnnotation(ExcelProperty.class);
                if (cur.index() < next.index()) {
                    swap(fields, i, j);
                }
            }
        }
    }

    private static void insertSort2(List<Field> fields) {
        // 边界条件
        if (fields == null || fields.size() == 1) {
            return;
        }
        for (int i = 0; i < fields.size(); i++) {
            for (int j = i; ((j - 1) >= 0) && (excelPropertyIndex(fields.get(j)) < excelPropertyIndex(fields.get(j-1))); j--) {
                swap(fields, j, j-1);
            }
        }
    }
    private static int excelPropertyIndex(Field field){
        ExcelProperty annotation = field.getAnnotation(ExcelProperty.class);
        if (annotation == null) {
            return -1;
        }
        return annotation.index();
    }
    private static void insertSort(List<Field> fields) {
        // 边界条件
        if (fields == null || fields.size() == 1) {
            return;
        }
        for (int i = 0; i < fields.size(); i++) {
            ExcelProperty cur = fields.get(i).getAnnotation(ExcelProperty.class);
            if (cur == null) {
                fields.remove(i);
                continue;
            }
            for (int j = 0; j < i; j++) {
                ExcelProperty next = fields.get(j).getAnnotation(ExcelProperty.class);
                if (next == null) {
                    fields.remove(j);
                    continue;
                }
                if (cur.index() < next.index()) {
                    swap(fields, i, j);
                }
            }
        }
    }

    private static void swap(Field[] fields, int var1, int var2) {
        Field temp = fields[var1];
        fields[var1] = fields[var2];
        fields[var2] = temp;
    }

    private static void swap(List<Field> fields, int var1, int var2) {
        Field a = fields.get(var1);
        Field b = fields.get(var2);

        fields.set(var1, b);
        fields.set(var2, a);
    }
}
