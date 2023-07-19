package com.zhanghp.other;

import com.zhanghp.EasyExcelApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zhanghp
 * @date 2023/7/18 19:29
 */
@SpringBootTest(classes = EasyExcelApplication.class)
public class Test {

    public static List<Map> get() throws ClassNotFoundException {
        Class<Enum> aClass = (Class<Enum>) Class.forName("com.zhanghp.enums." + "SexEnum");
        Enum[] enumConstants = aClass.getEnumConstants();
        Field[] fields = aClass.getDeclaredFields();
        List<Field> filterFields = Stream.of(fields).filter(s -> !s.toString().contains("static")).collect(Collectors.toList());
        List<Map> list = new ArrayList<>();
        for (Enum enumConstant : enumConstants) {
            Map<Object, Object> map = new HashMap<>();
            for (Field field : filterFields) {
                // 可访问私有变量
                field.setAccessible(true);
                Object o = null;
                try {
                    o = field.get(enumConstant);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                map.put(field.getName(), o);
            }
            list.add(map);
        }
        list.forEach(System.out::println);
        return list;
    }

    public static String nowTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        return sdf.format(calendar.getTime());
    }

    @org.junit.jupiter.api.Test
    public void test01() {
        String yesterday = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(yesterday);
    }
}
